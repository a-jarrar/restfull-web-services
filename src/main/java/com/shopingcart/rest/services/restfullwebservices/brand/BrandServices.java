package com.shopingcart.rest.services.restfullwebservices.brand;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class BrandServices {

    @Autowired
    private BrandRepository brandRepository;

    public BrandModel updateBrand(Integer brandId, BrandModel brandModel) {
        BrandModel oldBrand = brandRepository.findById(brandId)
                .map(BrandMapper.INSTANCE::entityToModel).orElse(brandModel);

        try {
            for (Field field : brandModel.getClass().getDeclaredFields()) {
                if (!field.getName().equalsIgnoreCase("brandId") &&
                        Objects.nonNull(PropertyUtils.getProperty(brandModel, field.getName()))) {
                    PropertyUtils.setProperty(oldBrand, field.getName(),
                            PropertyUtils.getProperty(brandModel, field.getName()));
                }
            }
        } catch (InvocationTargetException |
                IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return BrandMapper.INSTANCE
                .entityToModel(brandRepository.save(BrandMapper.INSTANCE.modelToEntity(oldBrand)));
    }
}
