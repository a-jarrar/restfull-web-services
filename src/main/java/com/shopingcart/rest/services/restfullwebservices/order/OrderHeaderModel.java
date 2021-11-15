package com.shopingcart.rest.services.restfullwebservices.order;

import com.shopingcart.rest.services.restfullwebservices.cart.Cart;
import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItem;

import java.util.Date;
import java.util.List;

public class OrderHeaderModel {

    private Integer orderId;
    private String orderName;
    private String description;
    private Date creationDate;
    private Date estimatedDeliveryDate;
    private Cart cart;
    private List<OrderItem> orderItemList;

    public OrderHeaderModel() {
    }

    public OrderHeaderModel(Integer orderId, String orderName, String description, Date creationDate, Date estimatedDeliveryDate, Cart cart, List<OrderItem> orderItemList) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.description = description;
        this.creationDate = creationDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.cart = cart;
        this.orderItemList = orderItemList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
