package com.shopingcart.rest.services.restfullwebservices.category;

import com.shopingcart.rest.services.restfullwebservices.product.ProductModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CategoryModel {

    private Integer categoryId;
    private String categoryName;
    private Date creationDate;
    private Set<ProductModel> productSet = new HashSet<>();

    public CategoryModel() {
    }

    public CategoryModel(Integer categoryId, String categoryName, Date creationDate, Set<ProductModel> productSet) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.creationDate = creationDate;
        this.productSet = productSet;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<ProductModel> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProductModel> productSet) {
        this.productSet = productSet;
    }
}
