package org.example.session05.bai1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = " org.example.session05")
public class WebConfig {
    @Bean
    public SpringResourceTemplateResolver templateResolver() {

        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

        resolver.setPrefix("/WEB-INF/views");
//        Prefix không đúng chuẩn Thymeleaf
//        Đang trỏ tới:
//        /WEB-INF/views
//        Đây là của JSP, không phải Thymeleaf
//        Thymeleaf chuẩn sẽ dùng:
//        /WEB-INF/templates/
        //sửa lại:
        resolver.setPrefix("/WEB-INF/views/templates/");

       // resolver.setSuffix(".jsp"); // sai Thymeleaf phải là ".html"
        resolver.setSuffix(".html");

        resolver.setCharacterEncoding("UTF-8");

        return resolver;

    }
}
