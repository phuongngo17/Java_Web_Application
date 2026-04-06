package org.example.session02.baitap01.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    // LỖI ở đây — Servlet Mapping bị đặt sai
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/api/*" };   // ← Chú ý dòng này
//        //DispatcherServlet chỉ xử lý các URL bắt đầu bằng /api/
//        //Nhưng bạn lại gọi:
//        //http://localhost:8080/demo/welcome
//        //-> URL này KHÔNG match /api/*
//        //-> Không vào được DispatcherServlet
//        //-> Tomcat trả về 404 Not Found
//    }
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
