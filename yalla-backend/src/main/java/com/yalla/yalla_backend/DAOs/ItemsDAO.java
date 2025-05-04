package com.yalla.yalla_backend.DAOs;

import com.yalla.yalla_backend.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemsDAO extends JpaRepository<Items, UUID> {
}
