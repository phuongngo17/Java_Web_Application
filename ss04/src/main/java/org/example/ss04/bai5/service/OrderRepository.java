package org.example.ss04.bai5.service;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String findById(Long id) {
        return "Thong tin don hang so " + id;
    }

    public String save() {
        return "Tao don hang thanh cong";
    }

    public String deleteById(Long id) {
        return "Da huy don hang so " + id;
    }

}