package org.example.ss04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//đánh dấu là lớp cấu hình
@Configuration
//Bật chế độ web mvc
@EnableWebMvc
//quét các bean đang cần được khởi tạo
@ComponentScan(basePackages = "org.example.ss04")
public class AppConfig {
    // cấu hình bean ViewResolver để đọc được view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //Cấu hình tiền tố
        viewResolver.setPrefix("/WEB-INF/views/");
        // cấu trúc hậu tộ
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
