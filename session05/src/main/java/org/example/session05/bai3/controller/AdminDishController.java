package org.example.session05.bai3.controller;

import org.example.session05.bai2.model.Dish;
import org.example.session05.bai3.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService service;

    @GetMapping("/bai3/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Dish dish = service.findById(id);

        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu");
            return "redirect:/bai2/dish";
        }

        model.addAttribute("dish", dish);
        return "edit_dish";
    }
}