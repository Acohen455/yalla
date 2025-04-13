package com.yalla.yalla_backend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItems {

    //!!! We SHOULDNT need to get this in a constructor, as it SHOULD be autogenerated -- check this later
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderItemId;

    //?? These are managed by the order and item fields; no need for separate fields
    //?? leaving this here for documentation sake
    /*
    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private UUID itemId;
     */

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Float priceAtTimeOfOrder;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items item;


    //constructors
    public OrderItems() {}

    public OrderItems(Orders order, Items item, Integer quantity, Float priceAtTimeOfOrder) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
        this.priceAtTimeOfOrder = priceAtTimeOfOrder;
    }

    //getters and setters

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(UUID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPriceAtTimeOfOrder() {
        return priceAtTimeOfOrder;
    }

    public void setPriceAtTimeOfOrder(Float priceAtTimeOfOrder) {
        this.priceAtTimeOfOrder = priceAtTimeOfOrder;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }


    //toString

    @Override
    public String toString() {
        return "OrderItems{" +
                "orderItemId=" + orderItemId +
                ", quantity=" + quantity +
                ", priceAtTimeOfOrder=" + priceAtTimeOfOrder +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}
