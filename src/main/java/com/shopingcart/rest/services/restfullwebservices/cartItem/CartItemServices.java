package com.shopingcart.rest.services.restfullwebservices.cartItem;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class CartItemServices {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItemModel updateCartItem(Integer cartItemSeqId, CartItemModel cartItemModel) {
        CartItemModel oldCartItem = cartItemRepository.findById(cartItemSeqId)
                .map(CartItemMapper.INSTANCE::entityToModel).orElse(cartItemModel);

        try {
            for (Field field : cartItemModel.getClass().getDeclaredFields()) {
                if (!field.getName().equalsIgnoreCase("cartItemSeqId") &&
                        Objects.nonNull(PropertyUtils.getProperty(cartItemModel, field.getName()))) {
                    PropertyUtils.setProperty(oldCartItem, field.getName(),
                            PropertyUtils.getProperty(cartItemModel, field.getName()));
                }
            }
        } catch (InvocationTargetException |
                IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return CartItemMapper.INSTANCE
                .entityToModel(cartItemRepository.save(CartItemMapper.INSTANCE.modelToEntity(oldCartItem)));
    }

    public CartItemModel increaseQuantity(Integer cartItemSeqId) {
        CartItemModel cartItem = cartItemRepository.findById(cartItemSeqId)
                .map(CartItemMapper.INSTANCE::entityToModel)
                .orElseThrow(() -> new RuntimeException("This does not exist"));

        cartItem.setQuantity(cartItem.getQuantity() + 1);
        return CartItemMapper.INSTANCE
                .entityToModel(cartItemRepository.save(CartItemMapper.
                        INSTANCE.modelToEntity(cartItem)));
    }

    public CartItemModel decreaseQuantity(Integer cartItemSeqId) {
        CartItemModel cartItem = cartItemRepository.findById(cartItemSeqId)
                .map(CartItemMapper.INSTANCE::entityToModel)
                .orElseThrow(() -> new RuntimeException("This cart item does not exist"));

        cartItem.setQuantity(cartItem.getQuantity() - 1);
        return CartItemMapper.INSTANCE
                .entityToModel(cartItemRepository.save(CartItemMapper.
                        INSTANCE.modelToEntity(cartItem)));
    }
}
