package org.example.session07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    String path = "C:\\Users\\HP\\IT203_Java\\IT210_Java_web_Application\\session07\\src\\main\\webapp\\images\\";
    @GetMapping
    public String formUpload(){
        return "form-upload";
    }
    @PostMapping
    public String handleUpload(@RequestParam(name = "file") MultipartFile file, Model model){
        if(file.isEmpty()){
            model.addAttribute("error", "Đang không có file lên");
            return "result";
        }
        //B1: lấy được tên file upload lên
        String fileName = file.getOriginalFilename();

        //B2: khởi tạo đối tượng file với đường dẫn mong muốn
        File convertFile = new File(path + fileName);

        //B3: ghi vào ổ cứng(dự án)
        try {
            file.transferTo(convertFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("img", fileName);
        return "result";
    }
}
