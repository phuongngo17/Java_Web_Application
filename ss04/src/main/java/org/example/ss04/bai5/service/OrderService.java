package org.example.ss04.bai5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public String createOrder() {
        return orderRepository.save();
    }

    public String deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }

}
