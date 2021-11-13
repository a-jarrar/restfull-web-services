package com.shopingcart.rest.services.restfullwebservices.cart;

import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItem;
import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {

    @Mapping(target = "cartItems", qualifiedByName = "CartItemList")
    CartModel entityToModel(Cart entity);

    Cart modelToEntity(CartModel model);

    @Named("CartItemList")
    @IterableMapping(qualifiedByName = "nonCyclicCartItem")
    List<CartItemModel> CartItemList(List<CartItem> cartItem);

    @Named("nonCyclicCartItem")
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "cart", ignore = true)
    CartItemModel nonCyclicCartItem(CartItem cartItem);

    static CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
}
