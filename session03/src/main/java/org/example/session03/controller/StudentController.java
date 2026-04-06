package org.example.session03.controller;

import org.example.session03.model.Student;
import org.example.session03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // UC-01 + UC-03
    @GetMapping
    public String list(
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String faculty,
            Model model) {

        List<Student> students = service.getAll(sortBy, search, faculty);

        model.addAttribute("students", students);
        model.addAttribute("count", students.size());

        return "students/list";
    }

    // UC-02
    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("student", service.findById(id));
        return "students/detail";
    }

    // UC-04
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("total", service.getAll(null,null,null).size());
        model.addAttribute("avgGpa", service.getAvgGpa());
        model.addAttribute("top", service.getTopStudent());
        model.addAttribute("stats", service.getStatusStats());

        return "students/dashboard";
    }
}
