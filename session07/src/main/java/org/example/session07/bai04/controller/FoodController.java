package org.example.session07.bai04.controller;

import org.example.session07.bai03.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static final List<Food> foodList = new ArrayList<>();

    private static final String UPLOAD_DIR = "C:\\Users\\HP\\IT203_Java\\IT210_Java_web_Application\\session07\\src\\main\\webapp\\images\\";

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("food", new Food());
        return "dish-add";
    }

    @PostMapping("/add")
    public String addFood(
            @ModelAttribute Food food,
            @RequestParam("image") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Chưa chọn file");
            return "redirect:/food/add";
        }

        if (file.getSize() > 2 * 1024 * 1024) {
            redirectAttributes.addFlashAttribute("error", "File > 2MB");
            return "redirect:/food/add";
        }

        String originalName = file.getOriginalFilename();

        if (originalName == null ||
                !(originalName.endsWith(".jpg") ||
                        originalName.endsWith(".png") ||
                        originalName.endsWith(".jpeg"))) {

            redirectAttributes.addFlashAttribute("error", "Sai định dạng file");
            return "redirect:/food/add";
        }

        if (food.getPrice() < 0) {
            redirectAttributes.addFlashAttribute("error", "Giá phải >= 0");
            return "redirect:/food/add";
        }

        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            String newFileName = System.currentTimeMillis() + "_" + originalName;

            String filePath = UPLOAD_DIR + newFileName;
            file.transferTo(new File(filePath));

            food.setImagePath(newFileName);

            // thêm vào list
            foodList.add(food);

            int id = foodList.size() - 1;

            redirectAttributes.addFlashAttribute("success", "Thêm thành công");

            return "redirect:/food/detail?id=" + id;

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Upload lỗi");
            return "redirect:/food/add";
        }
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model) {

        if (id < 0 || id >= foodList.size()) {
            return "error";
        }

        Food food = foodList.get(id);
        model.addAttribute("food", food);

        return "food-detail";
    }
}