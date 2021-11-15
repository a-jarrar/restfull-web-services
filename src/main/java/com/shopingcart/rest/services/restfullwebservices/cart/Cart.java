package com.shopingcart.rest.services.restfullwebservices.cart;

import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItem;
import com.shopingcart.rest.services.restfullwebservices.order.OrderHeader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Integer cartId;

    @NotNull
    private Double totalPrice;
    private Date creationDate;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToOne(mappedBy = "cart")
    private OrderHeader orderHeader;

    protected Cart() {

    }

    public Cart(Integer cartId, Double totalPrice, Date creationDate, List<CartItem> cartItems, OrderHeader orderHeader) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
        this.cartItems = cartItems;
        this.orderHeader = orderHeader;
    }

    public int getCartId() {
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public OrderHeader getOrderHeader() {
        return new OrderHeader();
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }
}
