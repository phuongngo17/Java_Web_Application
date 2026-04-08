package org.example.ss04.bai5.controller;

import org.example.ss04.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai5/orders")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Xem đơn hàng
    @GetMapping("/{id}")
    @ResponseBody
    public String getOrder(@PathVariable String id) {
        try {
            Long orderId = Long.parseLong(id);
            return orderService.getOrderById(orderId);
        } catch (Exception e) {
            return "ID don hang phai la mot so";
        }
    }

    //Tạo đơn hàng
    @PostMapping
    @ResponseBody
    public String createOrder() {
        return orderService.createOrder();
    }

    //Hủy đơn hàng
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}