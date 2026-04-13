package org.example.session07.controller;

import org.example.session07.model.Student;
import org.example.session07.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class StudentController {
    // cơ chế DI
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String home(Model model){
        //Gửi dữ liệu sang view
        model.addAttribute("students", studentRepository.getStudents());
        return "home";
    }

    @GetMapping("/views-add")
    public String viewAdd(Model model){
        model.addAttribute("student", new Student());
        return "form-add";
    }
    @PostMapping("/handle-add")
    public String handleAdd(@ModelAttribute(name="student") Student student){
        studentRepository.addStudent(student);
        return "redirect:/";
    }
}
