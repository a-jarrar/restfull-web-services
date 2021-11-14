package com.shopingcart.rest.services.restfullwebservices.cartItem;

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
public interface CartItemMapper {

    @Mapping(target = "product.cartItem", ignore = true)
    @Mapping(target = "product.brand", ignore = true)
    @Mapping(target = "cart.cartItems", ignore = true)
    @Mapping(target = "product.categorySet", qualifiedByName = "categorySet")
    CartItemModel entityToModel(CartItem entity);

    CartItem modelToEntity(CartItemModel model);

    @Named("categorySet")
    @IterableMapping(qualifiedByName = "ignoreProduct")
    Set<CategoryModel> categorySet(Set<Category> categorySet);

    @Named("ignoreProduct")
    @Mapping(target = "productSet", ignore = true)
    CategoryModel ignoreProduct(Category category);

    static CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);
}
