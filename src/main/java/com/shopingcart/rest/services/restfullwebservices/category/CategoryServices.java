package com.shopingcart.rest.services.restfullwebservices.category;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryModel updateCategory(Integer categoryId, CategoryModel categoryModel) {
        CategoryModel oldCategory = categoryRepository.findById(categoryId)
                .map(CategoryMapper.INSTANCE::entityToModel).orElse(categoryModel);

        try {
            for (Field field : categoryModel.getClass().getDeclaredFields()) {
                if (!field.getName().equalsIgnoreCase("categoryId") &&
                        Objects.nonNull(PropertyUtils.getProperty(categoryModel, field.getName()))) {
                    PropertyUtils.setProperty(oldCategory, field.getName(),
                            PropertyUtils.getProperty(categoryModel, field.getName()));
                }
            }
        } catch (InvocationTargetException |
                IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return CategoryMapper.INSTANCE
                .entityToModel(categoryRepository.save(CategoryMapper.INSTANCE.modelToEntity(oldCategory)));
    }
}
