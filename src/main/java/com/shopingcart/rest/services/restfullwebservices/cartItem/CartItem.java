package com.shopingcart.rest.services.restfullwebservices.cartItem;

import com.shopingcart.rest.services.restfullwebservices.cart.Cart;
import com.shopingcart.rest.services.restfullwebservices.product.Product;

import javax.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue
    private Integer cartItemSeqId;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    protected CartItem() {

    }

    public CartItem(Integer cartItemSeqId, Double price) {
        this.cartItemSeqId = cartItemSeqId;
        this.price = price;
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
}
