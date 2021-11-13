package com.shopingcart.rest.services.restfullwebservices.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CartResource {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartServices cartServices;

    @GetMapping("/carts")
    public List<CartModel> retriveAllCarts() {
        return cartRepository.findAll().stream().map(CartMapper.INSTANCE::entityToModel).collect(Collectors.toList());
    }

    @GetMapping("/carts/{cartId}")
    public Optional<CartModel> retriveCart(@PathVariable Integer cartId) {
        return cartRepository.findById(cartId).map(CartMapper.INSTANCE::entityToModel);
    }

    @PostMapping("/carts")
    public CartModel createCart(@RequestBody CartModel cartModel) {
        return CartMapper.INSTANCE
                .entityToModel((cartRepository.save(CartMapper.INSTANCE.modelToEntity(cartModel))));
    }

    @DeleteMapping("/carts/{cartId}")
    public void deleteCart(@PathVariable Integer cartId) {
        cartRepository.deleteById(cartId);
    }

    @PutMapping("/carts/{cartId}")
    public CartModel updateCart(@PathVariable Integer cartId, @RequestBody CartModel cartModel) {
        return cartServices.updateCart(cartId, cartModel);
    }
}
