package com.shopingcart.rest.services.restfullwebservices.brand;

import com.shopingcart.rest.services.restfullwebservices.product.ProductModel;

import java.util.List;
import java.util.Objects;

public class BrandModel {

    private Integer brandId;
    private String brandName;
    private List<ProductModel> product;

    public BrandModel() {
    }

    public BrandModel(Integer brandId, String brandName, List<ProductModel> product) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.product = product;
    }

    public Integer getBrandId() {
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

    public List<ProductModel> getProduct() {
        return product;
    }

    public void setProduct(List<ProductModel> product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandModel that = (BrandModel) o;
        return Objects.equals(brandId, that.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId);
    }
}
