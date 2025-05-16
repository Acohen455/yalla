package com.yalla.yalla_backend.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AppUserDetails extends UserDetails {
    UUID getUserId(); //this will fetch either the user OR vendor id
    String getRole(); //this grabs whether user or vendor
}
