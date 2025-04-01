package com.yalla.yalla_backend.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID addressId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer postalCode;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, name = "is_default")
    private boolean isDefault;


    //constructors including empty
    public Address(User user, String country, Integer postalCode, String address, boolean isDefault) {
        this.user = user;
        this.country = country;
        this.postalCode = postalCode;
        this.address = address;
        this.isDefault = isDefault;
    }

    public Address() {
    }

    //getters and setters
    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }


    //toString
    //TODO: CUSTOMIZE THIS LATER IF NECESSARY

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", user=" + user +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                ", address='" + address + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
