package org.example.session06.bth.controller;

import org.example.session06.bth.model.Course;
import org.example.session06.bth.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //    @GetMapping("/list")
//    public String listCourses(
//            @RequestParam(defaultValue = "ALL") String level,
//            @RequestParam(defaultValue = "999999999") BigDecimal maxFee,
//            Model model
//    )
    @GetMapping("/list")
    public String listCourses(
            @RequestParam(name = "level", defaultValue = "ALL") String level,
            @RequestParam(name = "maxFee", defaultValue = "999999999") BigDecimal maxFee,
            Model model
    ){
        List<Course> courses = courseService.filterCourses(level, maxFee);
        model.addAttribute("courses", courses);
        model.addAttribute("selectedLevel", level);
        model.addAttribute("maxFee", maxFee);
        return "course/list";
    }

    @GetMapping("/detail/{code}")
    public String courseDetail(@PathVariable String code, Model model) {
        return courseService.getByCode(code)
                .map(course -> {
                    model.addAttribute("course", course);
                    return "course/detail";
                })
                .orElse("redirect:/course/list");
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return courseService.getById(id)
                .map(course -> {
                    model.addAttribute("course", course);
                    return "course/edit";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Khong tim thay khoa hoc.");
                    return "redirect:/course/list";
                });
    }

    @PostMapping("/edit")
    public String updateCourse(@ModelAttribute("course") Course course, RedirectAttributes redirectAttributes) {
        courseService.updateCourse(course);
        redirectAttributes.addFlashAttribute("successMessage", "Cap nhat thong tin khoa hoc thanh cong.");
        return "redirect:/course/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (!courseService.deleteCourse(id)) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Khong the huy khoa hoc da co hoc vien dang ky");
            return "redirect:/course/list";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Da huy khoa hoc thanh cong.");
        return "redirect:/course/list";
    }

    @GetMapping("/consult")
    public String consultPage() {
        return "course/consult";
    }
}