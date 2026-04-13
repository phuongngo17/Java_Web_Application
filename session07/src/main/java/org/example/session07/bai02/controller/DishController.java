package org.example.session07.bai02.controller;

import org.example.session07.bai02.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/merchant/dish")
public class DishController {

    // chỉ viết 1 lần duy nhất
    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Món chính","Đồ uống","Tráng miệng","Topping");
    }

    // API 1: Mở form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    // API 2: Mở form chỉnh sửa
    @GetMapping("/edit")
    public String showEditForm(Model model){
//        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    // API 3: Mở trang tìm kiếm
    @GetMapping("/search")
    public String showSearchpage(){
        return "dish-search";
    }
}