package com.shopingcart.rest.services.restfullwebservices.order;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderHeaderMapper {

    OrderHeaderModel entityToModel(OrderHeader entity);

    OrderHeader modelToEntity(OrderHeaderModel model);

    static OrderHeaderMapper INSTANCE = Mappers.getMapper(OrderHeaderMapper.class);
}
