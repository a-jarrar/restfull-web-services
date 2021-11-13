package com.shopingcart.rest.services.restfullwebservices.brand;

import com.shopingcart.rest.services.restfullwebservices.product.Product;
import com.shopingcart.rest.services.restfullwebservices.product.ProductModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface BrandMapper {

    @Mapping(target = "product", qualifiedByName = "productList")
    BrandModel entityToModel(Brand entity);

    Brand modelToEntity(BrandModel model);

    @Named("productList")
    @IterableMapping(qualifiedByName = "nonCyclicProduct")
    List<ProductModel> productList(List<Product> product);

    @Named("nonCyclicProduct")
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "categorySet", ignore = true)
    @Mapping(target = "cartItem", ignore = true)
    ProductModel nonCyclicProduct(Product product);

    static BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
}
