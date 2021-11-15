package com.shopingcart.rest.services.restfullwebservices.order;

import com.shopingcart.rest.services.restfullwebservices.cart.Cart;
import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItem;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrderHeader {

    @Id
    @GeneratedValue
    private Integer orderId;
    private String orderName;
    private String description;
    private Date creationDate;
    private Date estimatedDeliveryDate;

    @OneToMany(mappedBy = "orderHeader")
    private List<OrderItem> orderItemList;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public OrderHeader() {
    }

    public OrderHeader(Integer orderId, String orderName, String description, Date creationDate, Date estimatedDeliveryDate, List<OrderItem> orderItemList, Cart cart) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.description = description;
        this.creationDate = creationDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.orderItemList = orderItemList;
        this.cart = cart;
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
