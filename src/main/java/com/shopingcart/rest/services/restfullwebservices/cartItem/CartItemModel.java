package com.shopingcart.rest.services.restfullwebservices.cartItem;

import com.shopingcart.rest.services.restfullwebservices.cart.CartModel;
import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItemModel;
import com.shopingcart.rest.services.restfullwebservices.product.ProductModel;

public class CartItemModel {

    private Integer cartItemSeqId;
    private Double price;
    private Integer quantity;
    private ProductModel product;
    private CartModel cart;
    private OrderItemModel orderItem;


    public CartItemModel() {
    }

    public CartItemModel(Integer cartItemSeqId, Double price, Integer quantity, ProductModel product, CartModel cart, OrderItemModel orderItem) {
        this.cartItemSeqId = cartItemSeqId;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
        this.orderItem = orderItem;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public OrderItemModel getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemModel orderItem) {
        this.orderItem = orderItem;
    }
}
