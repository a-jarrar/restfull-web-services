package com.shopingcart.rest.services.restfullwebservices.orderItem;

import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItem;
import com.shopingcart.rest.services.restfullwebservices.order.OrderHeader;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Integer orderItemSeqId;
    private String description;
    private Integer quantity;
    private Double price;

    @ManyToOne( fetch = FetchType.LAZY)
    private OrderHeader orderHeader;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_Item_seq_id", nullable = false)
    private CartItem cartItem;

    public OrderItem() {
    }

    public OrderItem(Integer orderItemSeqId, String description, Integer quantity, Double price, OrderHeader orderHeader, CartItem cartItem) {
        this.orderItemSeqId = orderItemSeqId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.orderHeader = orderHeader;
        this.cartItem = cartItem;
    }

    public Integer getOrderItemSeqId() {
        return orderItemSeqId;
    }

    public void setOrderItemSeqId(Integer orderItemSeqId) {
        this.orderItemSeqId = orderItemSeqId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }
}
