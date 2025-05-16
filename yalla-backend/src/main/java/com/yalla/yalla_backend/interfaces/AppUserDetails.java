package com.yalla.yalla_backend.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AppUserDetails extends UserDetails {
    UUID getUserId(); //this will fetch either the user OR vendor id
    String getRole(); //this grabs whether user, vendor, or admin
    //NOTE: ADMINS ARE GOING TO BE A SUBSET OF USERS
}
