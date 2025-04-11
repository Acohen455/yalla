package com.yalla.yalla_backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID vendorId;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String vendorEmail;

    @Column(nullable = false)
    private String vendorPhone;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<VendorItem> vendorItems = new ArrayList<>();



    //structs
    public Vendor() {
    }

    public Vendor(String name, String location, String vendorEmail, String vendorPhone, List<VendorItem> vendorItems) {
        this.name = name;
        this.location = location;
        this.vendorEmail = vendorEmail;
        this.vendorPhone = vendorPhone;
        this.vendorItems = vendorItems;
    }

    //getters and setters


    public UUID getVendorId() {
        return vendorId;
    }

    public void setVendorId(UUID vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(String vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

    public List<VendorItem> getVendorItems() {
        return vendorItems;
    }


    //sync method
    //This should be used instead of the setters and getters for vendor items
  //!!! MOVING SYNC INTO THE VENDOR ITEM CLASS
    public void addItem(Items item, float price, int quantity){
        new VendorItem(this, item, price, quantity);
    }




}
