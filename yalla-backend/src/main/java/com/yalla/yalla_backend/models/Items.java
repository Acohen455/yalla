package com.yalla.yalla_backend.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID itemId;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VendorItem> vendorItems = new HashSet<>;


    //adding helper method
    public void addVendorItem(Vendors vendor, Float vendorPrice, Integer stockQuantity){
        VendorItem vendorItem = new VendorItem(vendor, this, vendorPrice, stockQuantity);
        vendorItems.add(vendorItem);
        //TODO: Add this function in vendor
        vendor.getVendorItems().add(vendorItem);
    }

    //structs
    public Items() {
    }

    public Items(UUID itemId, Float price, String name, String description, String imageUrl, Set<VendorItem> vendorItems) {
        this.itemId = itemId;
        this.price = price;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.vendorItems = vendorItems;
    }

    //getters and setters
    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<VendorItem> getVendorItems() {
        return vendorItems;
    }

    public void setVendorItems(Set<VendorItem> vendorItems) {
        this.vendorItems = vendorItems;
    }

    //toString
    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", vendorItems=" + vendorItems +
                '}';
    }
}
