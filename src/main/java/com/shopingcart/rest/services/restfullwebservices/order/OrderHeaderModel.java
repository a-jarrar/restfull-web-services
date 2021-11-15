package com.shopingcart.rest.services.restfullwebservices.order;

import com.shopingcart.rest.services.restfullwebservices.cart.Cart;
import com.shopingcart.rest.services.restfullwebservices.cart.CartModel;
import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItem;
import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItemModel;

import java.util.Date;
import java.util.List;

public class OrderHeaderModel {

    private Integer orderId;
    private String orderName;
    private String description;
    private Date creationDate;
    private Date estimatedDeliveryDate;
    private CartModel cart;
    private List<OrderItemModel> orderItemList;

    public OrderHeaderModel() {
    }

    public OrderHeaderModel(Integer orderId, String orderName, String description, Date creationDate, Date estimatedDeliveryDate, CartModel cart, List<OrderItemModel> orderItemList) {
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

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }

    public List<OrderItemModel> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemModel> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
