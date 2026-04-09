package org.example.session05.controller;

import org.example.session05.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    // Hiển thị danh sách sản phẩm ra màn hình

    /**
     * Class Product
     * - id
     * - name
     * - price
     * - stock
     * - status
     * **/
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1,"Laptop",20000000,2,true),
                    new Product(2,"Điện thoại",25000000,10,true)
            )
    );
    @GetMapping
    public String home(Model model) {
        model.addAttribute("shop", products);
        return "home";
    }
}
