package com.shopingcart.rest.services.restfullwebservices.cartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CartItemResource {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartItemServices cartItemServices;

    @GetMapping("/cartItems")
    public List<CartItemModel> retriveAllCartItems() {
        return cartItemRepository.findAll().stream().map(CartItemMapper.INSTANCE::entityToModel).collect(Collectors.toList());
    }

    @GetMapping("/cartItems/{cartItemSeqId}")
    public Optional<CartItemModel> retriveCartItem(@PathVariable Integer cartItemSeqId) {
        return cartItemRepository.findById(cartItemSeqId).map(CartItemMapper.INSTANCE::entityToModel);
    }

    @PostMapping("/cartItems")
    public CartItemModel createCartItem(@RequestBody CartItemModel cartItemModel) {
        return CartItemMapper.INSTANCE
                .entityToModel((cartItemRepository.save(CartItemMapper.INSTANCE.modelToEntity(cartItemModel))));
    }

    @DeleteMapping("/cartItems/{cartItemSeqId}")
    public void deleteCartItem(@PathVariable Integer cartItemSeqId) {
        cartItemRepository.deleteById(cartItemSeqId);
    }

    @PutMapping("/cartItems/{cartItemSeqId}")
    public CartItemModel updateCartItem(@PathVariable Integer cartItemSeqId, @RequestBody CartItemModel cartItemModel) {
        return cartItemServices.updateCartItem(cartItemSeqId, cartItemModel);
    }

    @PutMapping("/cartItems/increase/{cartItemSeqId}")
    public CartItemModel increaseQuantity(@PathVariable Integer cartItemSeqId) {
        return cartItemServices.increaseQuantity(cartItemSeqId);
    }

    @PutMapping("/cartItems/decrease/{cartItemSeqId}")
    public CartItemModel decreaseQuantity(@PathVariable Integer cartItemSeqId) {
        return cartItemServices.decreaseQuantity(cartItemSeqId);
    }
}
