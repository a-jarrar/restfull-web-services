package com.shopingcart.rest.services.restfullwebservices.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderHeaderMapper {

    @Mapping(target = "cart.cartItems", ignore = true)
    @Mapping(target = "cart.orderHeader", ignore = true)
    OrderHeaderModel entityToModel(OrderHeader entity);

    OrderHeader modelToEntity(OrderHeaderModel model);

    static OrderHeaderMapper INSTANCE = Mappers.getMapper(OrderHeaderMapper.class);
}
