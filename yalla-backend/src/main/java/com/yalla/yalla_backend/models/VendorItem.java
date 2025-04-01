/*
THIS WAS UPDATED AFTER THE DIAGRAM

This is a join table to join vendors and items together rather than using a pure many to many
This is more scalable and better practice

 */


package com.yalla.yalla_backend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "vendor_items")
public class VendorItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Items item;

    @Column(nullable = false, name="vendor_price")
    private Float vendorPrice;

    @Column(nullable = false, name="stock_quantity")
    private Integer stockQuantity;


    //structs
    public VendorItem() {}

    public VendorItem(Vendor vendor, Items item, Float vendorPrice, Integer stockQuantity) {
        this.itemId = item.getItemId();
        this.vendor = vendor;
        this.item = item;
        this.vendorPrice = vendorPrice;
        this.stockQuantity = stockQuantity;
    }

    //getters and setters

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
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


    //toString

    @Override
    public String toString() {
        return "VendorItem{" +
                "itemId=" + itemId +
                ", vendor=" + vendor +
                ", item=" + item +
                ", vendorPrice=" + vendorPrice +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
