package com.yalla.yalla_backend.DTOs;


import com.yalla.yalla_backend.models.Address;
import com.yalla.yalla_backend.models.Orders;

import java.util.List;

//dto for secure data transmission -- ie. leave out password
public class UserDTO {

    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String role;
    public List<Address> addresses;
    public List<Orders> orders;


    //structs
    public UserDTO() {
    }

    public UserDTO(String username, String firstName, String lastName, String email, String role, List<Address> addresses, List<Orders> orders) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.addresses = addresses;
        this.orders = orders;
    }


    //getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }



    //toString
    //TODO: override later

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", addresses=" + addresses +
                ", orders=" + orders +
                '}';
    }
}
