package com.yalla.yalla_backend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;

    @Column(nullable = false)
    private Integer amount;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Items item;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;


    //structs
    public Transactions() {
    }

    public Transactions(UUID transactionId, Integer amount, Items item, Integer quantity, Orders order) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.item = item;
        this.quantity = quantity;
        this.order = order;
    }

    //getters and setters


    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public UUID getItemId() {
        return item.getItemId();
    }

    public void setItemId(UUID itemId) {
        this.item.setItemId(itemId);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    //toString
    //TODO: CUSTOMIZE THIS
    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", itemId=" + item.getItemId()+
                ", quantity=" + quantity +
                ", order=" + order +
                '}';
    }
}
