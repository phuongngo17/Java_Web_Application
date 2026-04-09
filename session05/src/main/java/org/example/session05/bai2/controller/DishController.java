package org.example.session05.bai2.controller;

import org.example.session05.bai2.model.Dish;
import org.example.session05.bai2.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/bai2/dish")
    public String getDishes(Model model) {
        List<Dish> dishes = dishService.getAllDishes();
        model.addAttribute("dish", dishes);
        return "dish_list";
    }
}