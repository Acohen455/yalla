package com.yalla.yalla_backend.DTOs;

import com.yalla.yalla_backend.models.VendorItem;

import java.util.ArrayList;
import java.util.List;

public class VendorDTO {

    private String name;
    private String location;
    private String vendorEmail;
    private String vendorPhone;
    private String vendorDescription;
    private String vendorImageUrl;
    private String vendorBannerUrl;
    private String vendorUsername;
    private List<VendorItem> vendorItems = new ArrayList<>();


    //structs
    public VendorDTO() {
    }

    public VendorDTO(String name, String location, String vendorEmail, String vendorPhone, String vendorDescription,
                     String vendorImageUrl, String vendorBannerUrl, String vendorUsername, List<VendorItem> vendorItems) {
        this.name = name;
        this.location = location;
        this.vendorEmail = vendorEmail;
        this.vendorPhone = vendorPhone;
        this.vendorDescription = vendorDescription;
        this.vendorImageUrl = vendorImageUrl;
        this.vendorBannerUrl = vendorBannerUrl;
        this.vendorUsername = vendorUsername;
        this.vendorItems = vendorItems;
    }


    //getters & setters


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

    public String getVendorDescription() {
        return vendorDescription;
    }

    public void setVendorDescription(String vendorDescription) {
        this.vendorDescription = vendorDescription;
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

    public List<VendorItem> getVendorItems() {
        return vendorItems;
    }

    public void setVendorItems(List<VendorItem> vendorItems) {
        this.vendorItems = vendorItems;
    }


    //toString
    //TODO: overwrite later

    @Override
    public String toString() {
        return "VendorDTO{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", vendorEmail='" + vendorEmail + '\'' +
                ", vendorPhone='" + vendorPhone + '\'' +
                ", vendorDescription='" + vendorDescription + '\'' +
                ", vendorImageUrl='" + vendorImageUrl + '\'' +
                ", vendorBannerUrl='" + vendorBannerUrl + '\'' +
                ", vendorUsername='" + vendorUsername + '\'' +
                ", vendorItems=" + vendorItems +
                '}';
    }
}
