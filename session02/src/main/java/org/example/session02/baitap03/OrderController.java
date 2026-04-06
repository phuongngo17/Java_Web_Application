package org.example.session02.baitap03;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String orders(
            HttpSession session,
            HttpServletRequest request,
            Model model) {

        // check login
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // fake data
        List<Order> orders = List.of(
                new Order("OD01", "Laptop", 15000000, new Date()),
                new Order("OD02", "Chuột", 200000, new Date()),
                new Order("OD03", "Bàn phím", 500000, new Date())
        );

        // request scope
        model.addAttribute("orders", orders);

        // application scope + chống race
        ServletContext app = request.getServletContext();

        synchronized (app) {
            Integer count = (Integer) app.getAttribute("totalViewCount");
            if (count == null) count = 0;
            count++;
            app.setAttribute("totalViewCount", count);
        }

        return "orders";
    }
}