package org.example.session05.bai3.service;

import org.example.session05.bai2.model.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {

    private List<Dish> list = new ArrayList<>();

    public AdminDishService() {
        list.add(new Dish(1, "Phở bò", 50000, true));
        list.add(new Dish(2, "Bún chả", 45000, false));
        list.add(new Dish(3, "Cơm rang", 40000, true));
    }

    public Dish findById(int id) {
        return list.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}