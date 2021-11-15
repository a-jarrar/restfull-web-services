package com.shopingcart.rest.services.restfullwebservices.cartItem;

import com.shopingcart.rest.services.restfullwebservices.cart.Cart;
import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItem;
import com.shopingcart.rest.services.restfullwebservices.product.Product;

import javax.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue
    private Integer cartItemSeqId;

    private Double price;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @OneToOne(mappedBy = "cartItem")
    private OrderItem orderItem;

    protected CartItem() {

    }

    public CartItem(Integer cartItemSeqId, Double price, Integer quantity, Product product, Cart cart, OrderItem orderItem) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
