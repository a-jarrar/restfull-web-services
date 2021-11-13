package com.shopingcart.rest.services.restfullwebservices.cartItem;

import com.shopingcart.rest.services.restfullwebservices.cart.CartModel;
import com.shopingcart.rest.services.restfullwebservices.product.ProductModel;

public class CartItemModel {

    private Integer cartItemSeqId;
    private Double price;
    private ProductModel product;
    private CartModel cart;

    public CartItemModel() {
    }

    public CartItemModel(Integer cartItemSeqId, Double price, ProductModel product, CartModel cart) {
        this.cartItemSeqId = cartItemSeqId;
        this.price = price;
        this.product = product;
        this.cart = cart;
    }

    public Integer getCartItemSeqId() {
        return cartItemSeqId;
    }

    public void setCartItemSeqId(Integer cartItemSeqId) {
        this.cartItemSeqId = cartItemSeqId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }
}
