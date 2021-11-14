package com.shopingcart.rest.services.restfullwebservices.product;

import com.shopingcart.rest.services.restfullwebservices.brand.BrandModel;
import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemModel;
import com.shopingcart.rest.services.restfullwebservices.category.CategoryModel;

import java.util.List;
import java.util.Set;

public class ProductModel {

    private Integer productId;
    private String productName;
    private String description;
    private Double salesPrice;
    private Double discountPrice;
    private Set<CategoryModel> categorySet;
    private BrandModel brand;
    private List<CartItemModel> cartItem;

    public ProductModel() {
    }

    public ProductModel(Integer productId, String productName, String description,
                        Double salesPrice, Double discountPrice, Set<CategoryModel> categorySet,
                        BrandModel brand, List<CartItemModel> cartItem) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.salesPrice = salesPrice;
        this.discountPrice = discountPrice;
        this.categorySet = categorySet;
        this.brand = brand;
        this.cartItem = cartItem;
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

    public Set<CategoryModel> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<CategoryModel> categorySet) {
        this.categorySet = categorySet;
    }

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public List<CartItemModel> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItemModel> cartItem) {
        this.cartItem = cartItem;
    }
}
