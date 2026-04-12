package org.example.session06.controller;

import org.example.session06.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    public BookController() {
        bookList.add(new Book(1, " Nhà Giả Kim", "Paulo Coelho ",95000));
        bookList.add(new Book(2, " Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", 68000));
        bookList.add(new Book(3, " Đắc Nhân Tâm", "Dale Carnegie", 76000));
        bookList.add(new Book(4, " Muôn Kiếp Nhân Sinh", "Nguyên Phong", 149000));
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookList);
        model.addAttribute("title", "Danh sách sách");
        return "books";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable int id, Model model) {
        Book book = bookList.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("book", book);
        model.addAttribute("title", "Chi tiết sách");
        return "book_detail";
    }
}
