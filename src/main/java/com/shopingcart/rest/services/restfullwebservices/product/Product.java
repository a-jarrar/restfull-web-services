package com.shopingcart.rest.services.restfullwebservices.product;

import com.shopingcart.rest.services.restfullwebservices.brand.Brand;
import com.shopingcart.rest.services.restfullwebservices.category.Category;
import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItem;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product{

    @Id
    @GeneratedValue
    private Integer productId;

    @NotNull
    private String productName;
    private String description;
    private Double salesPrice;
    private Double discountPrice;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "products_categories",
            joinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "productId",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                        @JoinColumn(name = "category_id", referencedColumnName = "categoryId",
                            nullable = false, updatable = false)})
    private Set<Category> categorySet = new HashSet<>();

    @ManyToOne( fetch = FetchType.LAZY)
    private Brand brand;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItem;

    protected void product() {

    }

    public void Product(Integer ProductId, String productName, String description, Double salesPrice, Double discountPrice) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.salesPrice = salesPrice;
        this.discountPrice = discountPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
