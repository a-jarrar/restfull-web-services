package com.shopingcart.rest.services.restfullwebservices.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServices productServices;

    @GetMapping("/products/")
    public List<ProductModel> retrieveAllProducts() {
        return productRepository.findAll()
                .stream().map(ProductMapper.INSTANCE::entityToModel).collect(Collectors.toList());
    }

    @GetMapping("/products/{productId}")
    public Optional<ProductModel> retrieveProduct(@PathVariable Integer productId) {
        return productRepository.findById(productId).map(ProductMapper.INSTANCE::entityToModel);
    }

    @GetMapping("/products")
    public List<ProductModel> retrieveProducts(@RequestParam(required = false) Integer categoryId,
                                               @RequestParam(required = false) Integer brandId,
                                               Pageable pageable) {
        return productServices.retrieveProducts(categoryId, brandId, pageable);
    }

    @PostMapping("/products")
    public ProductModel createProduct(@RequestBody ProductModel productModel) {
        return ProductMapper.INSTANCE
                .entityToModel((productRepository.save(ProductMapper.INSTANCE.modelToEntity(productModel))));
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productRepository.deleteById(productId);
    }

    @PutMapping("/products/{productId}")
    public ProductModel updateProduct(@PathVariable Integer productId, @RequestBody ProductModel productModel) {
        return productServices.updateProduct(productId, productModel);
    }
}
