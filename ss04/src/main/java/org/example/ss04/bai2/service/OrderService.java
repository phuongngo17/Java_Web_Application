package org.example.ss04.bai2.service;

import org.example.ss04.bai1.service.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private org.example.ss04.bai1.service.OrderRepository orderRepository;

    @Autowired
    public OrderService(org.example.ss04.bai1.service.OrderRepository orderRepository) {
        this.orderRepository = new OrderRepository();
    }

    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

}
