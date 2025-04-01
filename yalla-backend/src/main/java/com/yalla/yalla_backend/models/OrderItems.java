package com.yalla.yalla_backend.models;

import jakarta.persistence.*;

import java.util.UUID;

public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderItemId;

    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private UUID itemId;

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

    public OrderItems(UUID orderItemId, UUID orderId, UUID itemId, Integer quantity, Float priceAtTimeOfOrder) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.itemId = itemId;
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

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
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
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", priceAtTimeOfOrder=" + priceAtTimeOfOrder +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}
