package com.shopingcart.rest.services.restfullwebservices.orderItem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {

    OrderItemModel entityToModel(OrderItem entity);

    OrderItem modelToEntity(OrderItemModel model);

    static OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);
}
