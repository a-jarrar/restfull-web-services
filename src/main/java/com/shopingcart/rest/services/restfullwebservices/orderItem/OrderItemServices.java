package com.shopingcart.rest.services.restfullwebservices.orderItem;

import com.shopingcart.rest.services.restfullwebservices.order.OrderHeaderMapper;
import com.shopingcart.rest.services.restfullwebservices.order.OrderHeaderModel;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class OrderItemServices {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItemModel updateOrder(Integer orderItemSeqId, OrderItemModel orderItemModel) {

        OrderItemModel oldOrderItem = orderItemRepository.findById(orderItemSeqId)
                .map(OrderItemMapper.INSTANCE::entityToModel).orElse(orderItemModel);

        try {
            for (Field field : orderItemModel.getClass().getDeclaredFields()) {
                if (!field.getName().equalsIgnoreCase("orderItemSeqId") &&
                        Objects.nonNull(PropertyUtils.getProperty(orderItemModel, field.getName()))) {
                    PropertyUtils.setProperty(oldOrderItem, field.getName(),
                            PropertyUtils.getProperty(orderItemModel, field.getName()));
                }
            }
        } catch (InvocationTargetException |
                IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }
        return OrderItemMapper.INSTANCE
                .entityToModel(orderItemRepository.save(OrderItemMapper.INSTANCE.modelToEntity(oldOrderItem)));
    }
}
