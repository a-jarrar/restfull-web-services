package com.shopingcart.rest.services.restfullwebservices.category;

import com.shopingcart.rest.services.restfullwebservices.product.Product;
import com.shopingcart.rest.services.restfullwebservices.product.ProductModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface CategoryMapper {

    @Mapping(target = "productSet", qualifiedByName = "ProductSet")
    CategoryModel entityToModel(Category entity);
    Category modelToEntity(CategoryModel model);

    @Named("ProductSet")
    @IterableMapping(qualifiedByName = "nonCyclicProduct")
    Set<ProductModel> productSet(Set<Product> productSet);

    @Named("nonCyclicProduct")
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "categorySet", ignore = true)
    @Mapping(target = "cartItem", ignore = true)
    ProductModel nonCyclicProduct(Product product);

    static CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}
