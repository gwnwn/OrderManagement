package com.example.ecommerce.order;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private Long order_id;


    private Long user_id;
    private LocalDateTime orderDate;
    private BigDecimal amount;
    private Boolean orderStatus;
    private Boolean paymentStatus;

    public Orders() {
    }

    public Orders(Long order_id,
                 Long user_id,
                 BigDecimal amount,
                 LocalDateTime orderDate,
                 Boolean orderStatus,
                 Boolean paymentStatus
                 ) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.orderDate = orderDate;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
    }

    public Orders(
                 Long user_id,
                 LocalDateTime orderDate,
                 BigDecimal amount,
                 Boolean orderStatus,
                 Boolean paymentStatus
                 ) {
        this.user_id = user_id;
        this.orderDate = orderDate;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                ", orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
