package com.shopingcart.rest.services.restfullwebservices.order;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class OrderHeaderServices {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    public OrderHeaderModel updateOrder(Integer orderId, OrderHeaderModel orderHeaderModel) {

        OrderHeaderModel oldOrder = orderHeaderRepository.findById(orderId)
                .map(OrderHeaderMapper.INSTANCE::entityToModel).orElse(orderHeaderModel);

        try {
            for (Field field : orderHeaderModel.getClass().getDeclaredFields()) {
                if (!field.getName().equalsIgnoreCase("orderId") &&
                        Objects.nonNull(PropertyUtils.getProperty(orderHeaderModel, field.getName()))) {
                    PropertyUtils.setProperty(oldOrder, field.getName(),
                            PropertyUtils.getProperty(orderHeaderModel, field.getName()));
                }
            }
        } catch (InvocationTargetException |
                IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return OrderHeaderMapper.INSTANCE
                .entityToModel(orderHeaderRepository.save(OrderHeaderMapper.INSTANCE.modelToEntity(oldOrder)));
    }
}
