package com.yalla.yalla_backend.DAOs;

import com.yalla.yalla_backend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//creating a jpa repository
//takes type of entity + type of primary key
//we SHOULDNT need to add custom fetching methods here -- spring SHOULD do the work
//if need be we can come back to add custom queries/methods later
@Repository
public interface AddressDAO extends JpaRepository<Address, UUID> {
}
