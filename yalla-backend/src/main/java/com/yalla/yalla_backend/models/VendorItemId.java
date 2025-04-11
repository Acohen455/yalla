//This is a class for creating a composite primary key for the join table VendorItem

package com.yalla.yalla_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class VendorItemId {
    @Column(name = "vendor_id", nullable = false)
    private UUID vendorId;

    @Column(name = "item_id", nullable = false)
    private UUID itemId;

    //structs
    public VendorItemId() {
    }

    public VendorItemId(UUID vendorId, UUID itemId) {
        this.vendorId = vendorId;
        this.itemId = itemId;
    }


    //getters and setters
    public UUID getVendorId() {
        return vendorId;
    }

    public void setVendorId(UUID vendorId) {
        this.vendorId = vendorId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }


    //TODO: Check the logic here is correct -- maybe use a mock to test?
    //this must be done for JPA -- this determines how the composite PKs are compared for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorItemId that = (VendorItemId) o;
        return Objects.equals(vendorId, that.vendorId) &&
                Objects.equals(itemId, that.itemId);
    }

    //defines how the CPK is hashed
    @Override
    public int hashCode() {
        return Objects.hash(vendorId, itemId);
    }
}
