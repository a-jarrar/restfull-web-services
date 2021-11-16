package com.shopingcart.rest.services.restfullwebservices.order;

import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItem;
import com.shopingcart.rest.services.restfullwebservices.orderItem.OrderItemModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderHeaderMapper {

    @Mapping(target = "cart.cartItems", ignore = true)
    @Mapping(target = "cart.orderHeader", ignore = true)
    @Mapping(target = "orderItemList", qualifiedByName = "OrderItemList")
    OrderHeaderModel entityToModel(OrderHeader entity);

    @Named("OrderItemList")
    @IterableMapping(qualifiedByName = "nonCyclicOrderItem")
    List<OrderItemModel> OrderItemList(List<OrderItem> orderItem);

    @Named("nonCyclicOrderItem")
    @Mapping(target = "orderHeader", ignore = true)
    @Mapping(target = "cartItem", ignore = true)
    OrderItemModel nonCyclicOrderItem(OrderItem orderItem);

    OrderHeader modelToEntity(OrderHeaderModel model);

    static OrderHeaderMapper INSTANCE = Mappers.getMapper(OrderHeaderMapper.class);
}
