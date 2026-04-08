package org.example.ss04.bai3.controller;

import org.example.ss04.bai1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller("legacyControllerBai3")
@RequestMapping("/bai4")
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
    public String getOrderDetail(@PathVariable Long id) {
        return "Chi tiet don hang so " + id;
    }

    @PostMapping
    @ResponseBody
    public String createOrder() {
        return "Tao don hang thanh cong";
    }

    @GetMapping("/menu")
    @ResponseBody
    public String getMenu(
            @RequestParam(value = "category", required = false, defaultValue = "chay") String category) {

        return "Menu loai: " + category;
    }
    @GetMapping("/products")
    public String getProducts(
            @RequestParam String category,
            @RequestParam int limit,
            ModelMap model) {

        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tim kiem thanh cong");

        return "productList";
    }

}