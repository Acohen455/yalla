package com.yalla.yalla_backend.DAOs;

import com.yalla.yalla_backend.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdersDAO extends JpaRepository<Orders, UUID> {

}

