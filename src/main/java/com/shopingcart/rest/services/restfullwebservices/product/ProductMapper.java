package com.shopingcart.rest.services.restfullwebservices.product;

import com.shopingcart.rest.services.restfullwebservices.category.Category;
import com.shopingcart.rest.services.restfullwebservices.category.CategoryModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProductMapper {

    @Mapping(target = "brand.product", ignore = true)
    @Mapping(target = "cartItem", ignore = true)
    @Mapping(target = "categorySet", qualifiedByName = "CategorySet")
    ProductModel entityToModel(Product entity);
    Product modelToEntity(ProductModel model);

    @Named("CategorySet")
    @IterableMapping(qualifiedByName = "nonCyclicCategory")
    Set<CategoryModel> categorySet(Set<Category> categorySet);

    @Named("nonCyclicCategory")
    @Mapping(target = "productSet", ignore = true)
    CategoryModel nonCyclicCategory(Category category);

    static ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}
