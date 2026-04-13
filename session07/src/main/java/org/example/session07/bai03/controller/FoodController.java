package org.example.session07.bai03.controller;

import org.example.session07.bai03.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    // In-memory storage
    private static final List<Food> foodList = new ArrayList<>();

    // Đường dẫn lưu ảnh
    private static final String UPLOAD_DIR =
            "C:\\Users\\HP\\IT203_Java\\IT210_Java_web_Application\\session07\\src\\main\\webapp\\images\\";

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    // Hiển thị form thêm món
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("food", new Food());
        return "dish-add";
    }

    @PostMapping("/add")
    public String addFood(
            @ModelAttribute Food food,
            @RequestParam("image") MultipartFile file,
            Model model
    ) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Chưa chọn ảnh");
            return "dish-add";
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null ||
                !(fileName.endsWith(".jpg") ||
                        fileName.endsWith(".png") ||
                        fileName.endsWith(".jpeg"))) {

            model.addAttribute("error", "Chỉ chấp nhận .jpg, .png, .jpeg");
            return "dish-add";
        }

        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá phải >= 0");
            return "dish-add";
        }

        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filePath = UPLOAD_DIR + fileName;
            file.transferTo(new File(filePath));

            food.setImagePath(fileName);

            foodList.add(food);

            System.out.println("=== THÊM MÓN THÀNH CÔNG ===");
            System.out.println("Tên: " + food.getName());
            System.out.println("Danh mục: " + food.getCategory());
            System.out.println("Giá: " + food.getPrice());
            System.out.println("Ảnh: " + food.getImagePath());
            System.out.println("Tổng số món: " + foodList.size());

        } catch (IOException e) {
            model.addAttribute("error", "Upload thất bại");
            return "dish-add";
        }

        model.addAttribute("foods", foodList);
        return "food-list";
    }
}