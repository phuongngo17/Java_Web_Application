package org.example.ss04.controller;

import org.example.ss04.dao.StudentDAO;
import org.example.ss04.model.Student;
import org.example.ss04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//đánh dấu bean nó là controller
@Controller
//đánh dấu đây là đường dẫn đến controller
//Giống như người giúp việc làm được nhiều việc
@RequestMapping // mặc định là dấu /

//các annotation phổ biến:
/**
 * Các annotation k gì bean dùng để khởi tạo và sử dụng DI
 * - @Component: đánh dấu là bean để khởi tạo và k có ngữ nghĩa
 *
 * - @Controller: đánh dấu là bean và mục đích là điều hướng
 *
 * - @Service: Đánh dấu là bean và mục đích là nghiệp vụ
 *
 * - @Repository: Đánh dấu là bean và mục đích xử lý tương tác database
 *
 * @Autowired: Dùng để tiêm sự phụ thuộc (DI_ Dependency Injection)
 *
 **/
public class HomeController {
    //DI
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentDAO studentDAO;

    //chức năng 1 có đường dẫn gì
    //đại diện cho 1 tính năng của người giúp việc

    /**
     * Biến của @RequestMapping
     * - @GetMapping: đại diện cho phương thức GET - cần tập trung
     * - @PostMapping: đại diện cho phương thức POST - cần tập trung
     * - @PutMapping: đại diện cho phương thức PUT
     * - @PatchMapping: đại diện cho phương thức PATCH
     * - @DeleteMapping: đại diện phương thức DELETE
     * **/

    //    @RequestMapping(method = RequestMethod.GET) - cách cũ
    @GetMapping //cách mới
    public String home(Model model) {
        List<Student> students = studentService.getAllStudent();
        System.out.println(students);
        model.addAttribute("students", students);
        return "home";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "keyword",defaultValue = "") String keyword, Model model) {
        System.out.println("nội dung:" + keyword);
        //tìm kiếm
        List<Student> students = studentDAO.search(keyword);
        model.addAttribute("students", students);
        return "home";
    }
    //thường là những trang detail(chi tiết)
    //id ở đường dẫn có thể đặt theo tùy biến
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id) {
        System.out.println("Nội dụng giá trị trên đường dẫn: " + id);

        return "home";
    }

}
