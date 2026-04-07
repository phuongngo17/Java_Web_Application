package org.example.hn_k24_cntt4_ngothihoaiphuong.controller;

import org.example.hn_k24_cntt4_ngothihoaiphuong.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployees(Model model) {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "Nguyen Van A", "Dao tao", 12000));
        list.add(new Employee(2, "Tran Thi B", "Dao tao", 8000));
        list.add(new Employee(3, "Le Van C", "Dao tao", 15000));

        model.addAttribute("employees", list);

        return "employee_list";
    }
}
