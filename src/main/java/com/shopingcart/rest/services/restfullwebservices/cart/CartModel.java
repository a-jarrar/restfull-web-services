package com.shopingcart.rest.services.restfullwebservices.cart;

import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemModel;

import java.util.Date;
import java.util.List;

public class CartModel {

    private Integer cartId;
    private Double totalPrice;
    private Date creationDate;
    private List<CartItemModel> cartItems;

    public CartModel() {
    }

    public CartModel(Integer cartId, Double totalPrice, Date creationDate, List<CartItemModel> cartItems) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
        this.cartItems = cartItems;
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
}
