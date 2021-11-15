package com.shopingcart.rest.services.restfullwebservices.cartItem;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemMapper {

    @Mapping(target = "product.cartItem", ignore = true)
    @Mapping(target = "product.brand", ignore = true)
    @Mapping(target = "product.categorySet", ignore = true)
    @Mapping(target = "cart.cartItems", ignore = true)
    @Mapping(target = "cart.orderHeader", ignore = true)
    @Mapping(target = "orderItem.cartItem", ignore = true)
    @Mapping(target = "orderItem.orderHeader", ignore = true)
    CartItemModel entityToModel(CartItem entity);

    CartItem modelToEntity(CartItemModel model);

    static CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);
}
