package com.shopingcart.rest.services.restfullwebservices.cart;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class CartServices {

    @Autowired
    private CartRepository cartRepository;

    public CartModel updateCart(Integer cartId, CartModel cartModel) {
        CartModel oldCart = cartRepository.findById(cartId)
                .map(CartMapper.INSTANCE::entityToModel).orElse(cartModel);

        try {
            for (Field field : cartModel.getClass().getDeclaredFields()) {
                if (!field.getName().equalsIgnoreCase("cartId") &&
                        Objects.nonNull(PropertyUtils.getProperty(cartModel, field.getName()))) {
                    PropertyUtils.setProperty(oldCart, field.getName(),
                            PropertyUtils.getProperty(cartModel, field.getName()));
                }
            }
        } catch (InvocationTargetException |
                IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }

        return CartMapper.INSTANCE
                .entityToModel(cartRepository.save(CartMapper.INSTANCE.modelToEntity(oldCart)));
    }
}
