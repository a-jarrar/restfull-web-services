package com.shopingcart.rest.services.restfullwebservices.orderItem;

import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemModel;
import com.shopingcart.rest.services.restfullwebservices.order.OrderHeaderModel;

public class OrderItemModel {

    private Integer orderItemSeqId;
    private String description;
    private Integer quantity;
    private Double price;
    private CartItemModel cartItem;
    private OrderHeaderModel orderHeader;

    public OrderItemModel() {
    }

    public OrderItemModel(Integer orderItemSeqId, String description, Integer quantity, Double price, CartItemModel cartItem, OrderHeaderModel orderHeader) {
        this.orderItemSeqId = orderItemSeqId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.cartItem = cartItem;
        this.orderHeader = orderHeader;
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

    public CartItemModel getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItemModel cartItem) {
        this.cartItem = cartItem;
    }

    public OrderHeaderModel getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeaderModel orderHeader) {
        this.orderHeader = orderHeader;
    }
}
