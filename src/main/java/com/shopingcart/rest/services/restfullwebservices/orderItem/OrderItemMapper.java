package com.shopingcart.rest.services.restfullwebservices.orderItem;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {

    @Mapping(target = "orderHeader.orderItemList", ignore = true)
    @Mapping(target = "orderHeader.cart", ignore = true)
    @Mapping(target = "cartItem.orderItem", ignore = true)
    @Mapping(target = "cartItem.cart", ignore = true)
    @Mapping(target = "cartItem.product", ignore = true)
    OrderItemModel entityToModel(OrderItem entity);

    OrderItem modelToEntity(OrderItemModel model);

    static OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);
}
