package com.shopingcart.rest.services.restfullwebservices.orderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderItemResource {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemServices orderItemServices;

    @GetMapping("/orderItems")
    public List<OrderItemModel> retrieveAllOrderItems() {
        return orderItemRepository.findAll()
                .stream().map(OrderItemMapper.INSTANCE::entityToModel).collect(Collectors.toList());
    }

    @GetMapping("/orderItems/{orderItemSeqId}")
    public Optional<OrderItemModel> retrieveOrderItem(@PathVariable Integer orderItemSeqId) {
        return orderItemRepository.findById(orderItemSeqId).map(OrderItemMapper.INSTANCE::entityToModel);
    }

    @PostMapping("/orderItems/{orderItemSeqId}")
    public OrderItemModel createOrderItem(@RequestBody OrderItemModel orderItemModel) {
        return OrderItemMapper.INSTANCE
                .entityToModel((orderItemRepository.save(OrderItemMapper.INSTANCE.modelToEntity(orderItemModel))));
    }

    @DeleteMapping("/orderItems/{orderItemSeqId}")
    public void deleteOrderItem(@PathVariable Integer orderItemSeqId) {
        orderItemRepository.deleteById(orderItemSeqId);
    }

    @PutMapping("/orderItems/{orderItemSeqId}")
    public OrderItemModel updateOrder(@PathVariable Integer orderItemSeqId, @RequestBody OrderItemModel orderItemModel) {
        return orderItemServices.updateOrder(orderItemSeqId, orderItemModel);
    }
}
