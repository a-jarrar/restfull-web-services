package com.shopingcart.rest.services.restfullwebservices.cart;

import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemModel;
import com.shopingcart.rest.services.restfullwebservices.order.OrderHeader;

import java.util.Date;
import java.util.List;

public class CartModel {

    private Integer cartId;
    private Double totalPrice;
    private Date creationDate;
    private List<CartItemModel> cartItems;
    private OrderHeader orderHeader;

    public CartModel() {
    }

    public CartModel(Integer cartId, Double totalPrice, Date creationDate, List<CartItemModel> cartItems, OrderHeader orderHeader) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
        this.cartItems = cartItems;
        this.orderHeader = orderHeader;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<CartItemModel> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemModel> cartItems) {
        this.cartItems = cartItems;
    }

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }
}
