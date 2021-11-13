package com.shopingcart.rest.services.restfullwebservices.cart;

import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemMapper;
import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemModel;
import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemRepository;
import com.shopingcart.rest.services.restfullwebservices.cartItem.CartItemResource;
import com.shopingcart.rest.services.restfullwebservices.product.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductResource productResource;

    @Autowired
    private CartResource cartResource;

    @Autowired
    private CartItemResource cartItemResource;

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

    public CartModel addToCart(Integer cartId, Integer productId) {
        CartItemModel cartItem = cartItemRepository
                .findByProductProductIdAndCartCartId(productId, cartId)
                .map(CartItemMapper.INSTANCE::entityToModel)
                .orElseGet(() -> {
                    CartItemModel cartItemModel = new CartItemModel();
                    CartModel cart = cartRepository.findById(cartId)
                            .map(CartMapper.INSTANCE::entityToModel)
                            .orElseThrow(() -> new RuntimeException("This cart does not exist"));
                    ProductModel product = productRepository.findById(productId)
                            .map(ProductMapper.INSTANCE::entityToModel)
                            .orElseThrow(() -> new RuntimeException("This product does not exist"));
                    cartItemModel.setQuantity(0);
                    cartItemModel.setCart(cart);
                    cartItemModel.setProduct(product);
                    cartItemModel.setPrice(product.getSalesPrice());
                    return cartItemResource.createCartItem(cartItemModel);
                });
        cartResource.updateCart(cartItem.getCart().getCartId(), cartItem.getCart());
        cartItemResource.increaseQuantity(cartItem.getCartItemSeqId());
        return cartResource.retriveCart(cartId).orElseThrow(() -> new RuntimeException("Failure at add to cart"));
    }
}
