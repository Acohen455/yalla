/*
THIS WAS UPDATED AFTER THE DIAGRAM

This is a join table to join vendors and items together rather than using a pure many to many
This is more scalable and better practice

 */


package com.yalla.yalla_backend.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "vendor_items")
public class VendorItem {

    @EmbeddedId
    private VendorItemId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("vendorId")
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    @JoinColumn(name = "item_id", nullable = false)
    private Items item;

    @Column(nullable = false, name="vendor_price")
    private Float vendorPrice;

    @Column(nullable = false, name="stock_quantity")
    private Integer stockQuantity;


    //structs
    public VendorItem() {}

    //THIS CONSTRUCTOR NOW HAS SYNC BUILT IN
    public VendorItem(Vendor vendor, Items item, Float vendorPrice, Integer stockQuantity) {
        this.vendor = vendor;
        this.item = item;
        this.vendorPrice = vendorPrice;
        this.stockQuantity = stockQuantity;
        vendor.getVendorItems().add(this);
        item.getVendorItems().add(this);
    }

    //getters and setters

    public VendorItemId getId() {
        return id;
    }

    public void setId(VendorItemId id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Float getVendorPrice() {
        return vendorPrice;
    }

    public void setVendorPrice(Float vendorPrice) {
        this.vendorPrice = vendorPrice;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    //!! Overrides to have different comparison logic here than vendoritemid
    //!! In vendoritemid these are comparing database values (ie. raw column values
    //!! here we're comparing objects
    //This version assumes vendor stock and price is unique to the vendor + item combo
    //TODO: see if this needs to be changed later to allow variance in price per item for the same vendor, ie. in case of sales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorItem vendorItem = (VendorItem) o;
        return vendor.equals(vendorItem.vendor) && item.equals(vendorItem.item);
    }


    //This hashcode is better than having all fields
    //If two objects are equal, they should have the same hashcode
    //With including all fields but not comparing, we would be breaking this rule potentially
    //we also do not want to include mutable fields in the hashcode
    @Override
    public int hashCode() {
        return Objects.hash(vendor, item);
    }

    //tostring

    @Override
    public String toString() {
        return "VendorItem{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", item=" + item +
                ", vendorPrice=" + vendorPrice +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}


