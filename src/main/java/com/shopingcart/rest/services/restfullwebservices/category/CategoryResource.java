package com.shopingcart.rest.services.restfullwebservices.category;

import com.shopingcart.rest.services.restfullwebservices.product.Product;
import com.shopingcart.rest.services.restfullwebservices.product.ProductMapper;
import com.shopingcart.rest.services.restfullwebservices.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/categories")
    public List<CategoryModel> retrieveAllCategories() {
        return categoryRepository.findAll()
                .stream().map(CategoryMapper.INSTANCE::entityToModel).collect(Collectors.toList());
    }

    @GetMapping("/categories/{categoryId}")
    public Optional<CategoryModel> retrieveCategory(@PathVariable Integer categoryId) {
        return categoryRepository.findById(categoryId).map(CategoryMapper.INSTANCE::entityToModel);
    }

    @PostMapping("/categories/{categoryId}")
    public CategoryModel createCategory(@RequestBody CategoryModel categoryModel) {
        return CategoryMapper.INSTANCE
                .entityToModel((categoryRepository.save(CategoryMapper.INSTANCE.modelToEntity(categoryModel))));
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @PutMapping("/categories/{categoryId}")
    public CategoryModel updateCategory(@PathVariable Integer categoryId, @RequestBody CategoryModel categoryModel) {
        return categoryServices.updateCategory(categoryId, categoryModel);
    }
}
