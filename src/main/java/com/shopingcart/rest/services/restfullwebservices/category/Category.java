package com.shopingcart.rest.services.restfullwebservices.category;

import com.shopingcart.rest.services.restfullwebservices.product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer categoryId;
    @NotNull
    private String categoryName;
    private Date creationDate;

    @ManyToMany(mappedBy = "categorySet", fetch = FetchType.LAZY)
    private Set<Product> productSet = new HashSet<>();

    protected Category() {

    }

    public Category(Integer categoryId, String categoryName, Date creationDate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.creationDate = creationDate;
    }

    public int getCategoryId() {
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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
