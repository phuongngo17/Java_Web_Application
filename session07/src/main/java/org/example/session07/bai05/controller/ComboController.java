package org.example.session07.bai05.controller;

import org.example.session07.bai05.model.Combo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/combo")
public class ComboController {

    private static final List<Combo> comboList = new ArrayList<>();
    private static final String UPLOAD_DIR = "C:/RikkeiFood_Temp/";

    @ModelAttribute("foods")
    public List<String> getFoods() {
        return Arrays.asList("Trà sữa", "Bún bò", "Cơm gà", "Pizza", "Hamburger");
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("combo", new Combo());
        return "combo-add";
    }

    @PostMapping("/add")
    public String addCombo(
            @ModelAttribute Combo combo,
            @RequestParam("bannerFile") MultipartFile file,
            Model model
    ) {

        if (combo.getItemList() == null || combo.getItemList().size() < 2) {
            model.addAttribute("error", "Combo phải có ít nhất 2 món");
            return "combo-add";
        }

        if (file.isEmpty()) {
            model.addAttribute("error", "Chưa chọn banner");
            return "combo-add";
        }

        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            file.transferTo(new File(UPLOAD_DIR + fileName));

            combo.setBanner(fileName);

            comboList.add(combo);

            System.out.println("=== COMBO ===");
            System.out.println("{");
            System.out.println("  name: " + combo.getName());
            System.out.println("  items: " + combo.getItemList());
            System.out.println("  banner: " + combo.getBanner());
            System.out.println("}");

        } catch (IOException e) {
            model.addAttribute("error", "Upload lỗi");
            return "combo-add";
        }

        model.addAttribute("combo", combo);
        return "combo-detail";
    }
}