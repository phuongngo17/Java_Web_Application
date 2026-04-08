package org.example.ss04.bai1.controller;

import org.example.ss04.bai1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("legacyControllerBai1")
@RequestMapping("/bai1/orders")
public class LegacyController {

    private OrderService orderService;
    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService =  orderService;
    }

    @GetMapping
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    @ResponseBody
    public String createOrder() {
        return "Tao don hang thanh cong";
    }

}