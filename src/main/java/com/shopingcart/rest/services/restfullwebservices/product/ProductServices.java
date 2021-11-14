package com.shopingcart.rest.services.restfullwebservices.product;

import com.shopingcart.rest.services.restfullwebservices.brand.Brand;
import com.shopingcart.rest.services.restfullwebservices.brand.BrandRepository;
import com.shopingcart.rest.services.restfullwebservices.category.Category;
import com.shopingcart.rest.services.restfullwebservices.category.CategoryRepository;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    public ProductModel updateProduct(Integer productId, ProductModel productModel) {
        ProductModel oldProduct = productRepository.findById(productId)
                .map(ProductMapper.INSTANCE::entityToModel).orElse(productModel);

        try {
            for (Field field : productModel.getClass().getDeclaredFields()) {
                if (!field.getName().equalsIgnoreCase("productId") &&
                        Objects.nonNull(PropertyUtils.getProperty(productModel, field.getName()))) {
                    PropertyUtils.setProperty(oldProduct, field.getName(),
                            PropertyUtils.getProperty(productModel, field.getName()));
                }
            }
        } catch (InvocationTargetException |
                IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return ProductMapper.INSTANCE
                .entityToModel(productRepository.save(ProductMapper.INSTANCE.modelToEntity(oldProduct)));
    }

    public List<ProductModel> retrieveProducts(Integer categoryId, Integer brandId, Pageable pageable) {

        if (Objects.nonNull(categoryId)) {
            Optional<Category> category = categoryRepository.findById(categoryId);

            if (category.isPresent()) {
                List<ProductModel> productList = category.get().getProductSet().stream()
                        .map(ProductMapper.INSTANCE::entityToModel).collect(Collectors.toList());

                sortList(productList, pageable);
                int start = Math.min(pageable.getPageNumber() * pageable.getPageSize(), productList.size());
                int end = Math.min((pageable.getPageNumber() + 1) * pageable.getPageSize() - 1, productList.size());
                return productList.subList(start, end);
            }
        } else if (Objects.nonNull(brandId)) {
            Optional<Brand> brand = brandRepository.findById(brandId);

            if (brand.isPresent()) {
                List<ProductModel> productList = brand.get().getProduct().stream()
                        .map(ProductMapper.INSTANCE::entityToModel).collect(Collectors.toList());

                sortList(productList, pageable);
                int start = Math.min(pageable.getPageNumber() * pageable.getPageSize(), productList.size() - 1);
                int end = Math.min((pageable.getPageNumber() + 1) * pageable.getPageSize() - 1, productList.size() - 1);
                return productList.subList(start, end);
            }
        }

        return new ArrayList<>();
    }

    private void sortList(List<ProductModel> productList, Pageable pageable) {
        pageable.getSort().get().filter(order -> order.getProperty().equalsIgnoreCase("discountPrice") ||
                order.getProperty().equalsIgnoreCase("salesPrice")).forEach(order -> {
            if (order.getDirection().isAscending()) {
                if (order.getProperty().equalsIgnoreCase("discountPrice")) {
                    productList.sort(Comparator.comparing(ProductModel::getDiscountPrice));
                } else {
                    productList.sort(Comparator.comparing(ProductModel::getSalesPrice));
                }
            } else {
                if (order.getProperty().equalsIgnoreCase("discountPrice")) {
                    productList.sort(Comparator.comparing(ProductModel::getDiscountPrice).reversed());
                } else {
                    productList.sort(Comparator.comparing(ProductModel::getSalesPrice).reversed());
                }
            }
        });
    }
}
