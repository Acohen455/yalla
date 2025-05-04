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

    @Column(nullable = false)
    private String vendorDescription;


    //TODO: Add password encryption/security
    @Column(nullable = false)
    private String vendorPassword;

    @Column(nullable = false)
    private String vendorImageUrl;

    @Column(nullable = false)
    private String vendorBannerUrl;

    @Column(nullable = false)
    private String vendorUsername;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<VendorItem> vendorItems = new ArrayList<>();



    //structs
    //empty
    public Vendor() {
    }

    //no login info or images
    public Vendor(String name, String location, String vendorEmail, String vendorPhone, List<VendorItem> vendorItems) {
        this.name = name;
        this.location = location;
        this.vendorEmail = vendorEmail;
        this.vendorPhone = vendorPhone;
        this.vendorItems = vendorItems;
    }

    //all args minus images
    public Vendor(UUID vendorId, String name, String location, String vendorEmail, String vendorPhone, String vendorDescription, String vendorPassword,
                  String vendorUsername, List<VendorItem> vendorItems) {
        this.vendorId = vendorId;
        this.name = name;
        this.location = location;
        this.vendorEmail = vendorEmail;
        this.vendorPhone = vendorPhone;
        this.vendorDescription = vendorDescription;
        this.vendorPassword = vendorPassword;
        this.vendorItems = vendorItems;
        this.vendorUsername = vendorUsername;
    }

    //struct for all args including images
    public Vendor(UUID vendorId, String name, String location, String vendorEmail, String vendorPhone,
                  String vendorDescription, String vendorPassword, String vendorImageUrl, String vendorBannerUrl,
                  String vendorUsername, List<VendorItem> vendorItems) {
        this.vendorId = vendorId;
        this.name = name;
        this.location = location;
        this.vendorEmail = vendorEmail;
        this.vendorPhone = vendorPhone;
        this.vendorDescription = vendorDescription;
        this.vendorPassword = vendorPassword;
        this.vendorImageUrl = vendorImageUrl;
        this.vendorBannerUrl = vendorBannerUrl;
        this.vendorUsername = vendorUsername;
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

    public String getVendorDescription() {
        return vendorDescription;
    }

    public void setVendorDescription(String vendorDescription) {
        this.vendorDescription = vendorDescription;
    }

    public String getVendorPassword() {
        return vendorPassword;
    }

    public void setVendorPassword(String vendorPassword) {
        this.vendorPassword = vendorPassword;
    }

    public void setVendorItems(List<VendorItem> vendorItems) {
        this.vendorItems = vendorItems;
    }

    public String getVendorImageUrl() {
        return vendorImageUrl;
    }

    public void setVendorImageUrl(String vendorImageUrl) {
        this.vendorImageUrl = vendorImageUrl;
    }

    public String getVendorBannerUrl() {
        return vendorBannerUrl;
    }

    public void setVendorBannerUrl(String vendorBannerUrl) {
        this.vendorBannerUrl = vendorBannerUrl;
    }

    public String getVendorUsername() {
        return vendorUsername;
    }

    public void setVendorUsername(String vendorUsername) {
        this.vendorUsername = vendorUsername;
    }

    //sync method
    //This should be used instead of the setters and getters for vendor items
  //!!! MOVING SYNC INTO THE VENDOR ITEM CLASS
    public void addItem(Items item, float price, int quantity){
        new VendorItem(this, item, price, quantity);
    }




}
