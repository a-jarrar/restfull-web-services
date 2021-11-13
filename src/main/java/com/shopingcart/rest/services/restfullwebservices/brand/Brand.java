package com.shopingcart.rest.services.restfullwebservices.brand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopingcart.rest.services.restfullwebservices.product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private Integer brandId;

    @NotNull
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<Product> product;

    protected Brand() {

    }

    public Brand(Integer brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}
