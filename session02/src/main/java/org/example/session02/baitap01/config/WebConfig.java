package org.example.session02.baitap01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "com.demo.service")  // ← Chú ý dòng này
// Spring chỉ scan trong:
// com.demo.service
//Nhưng Controller thường nằm ở:
//com.demo.controller
//Spring MVC sẽ:
//KHÔNG tìm thấy @Controller
//KHÔNG đăng ký handler mapping
//Không map /welcome -> method nào cả
@ComponentScan(basePackages = "com.demo")
public class WebConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

