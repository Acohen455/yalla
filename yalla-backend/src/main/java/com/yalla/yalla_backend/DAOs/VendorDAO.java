package com.yalla.yalla_backend.DAOs;

import com.yalla.yalla_backend.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendorDAO extends JpaRepository<Vendor, UUID> {
    UserDetails findByUsername(String username);
}
