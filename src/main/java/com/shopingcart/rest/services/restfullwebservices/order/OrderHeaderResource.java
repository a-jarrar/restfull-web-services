package com.shopingcart.rest.services.restfullwebservices.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderHeaderResource {

    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private OrderHeaderServices orderHeaderServices;

    @GetMapping("/orders")
    public List<OrderHeaderModel> retrieveAllOrders() {
        return orderHeaderRepository.findAll()
                .stream().map(OrderHeaderMapper.INSTANCE::entityToModel).collect(Collectors.toList());
    }

    @GetMapping("/orders/orderId}")
    public Optional<OrderHeaderModel> retrieveOrder(@PathVariable Integer orderId) {
        return orderHeaderRepository.findById(orderId).map(OrderHeaderMapper.INSTANCE::entityToModel);
    }

    @PostMapping("/orders/{orderId}")
    public OrderHeaderModel createOrder(@RequestBody OrderHeaderModel orderModel) {
        return OrderHeaderMapper.INSTANCE
                .entityToModel((orderHeaderRepository.save(OrderHeaderMapper.INSTANCE.modelToEntity(orderModel))));
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        orderHeaderRepository.deleteById(orderId);
    }

    @PutMapping("/orders/{orderId}")
    public OrderHeaderModel updateOrder(@PathVariable Integer orderId, @RequestBody OrderHeaderModel orderHeaderModel) {
        return orderHeaderServices.updateOrder(orderId, orderHeaderModel);
    }

}
