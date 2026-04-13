package org.example.session07.bai01.controller;

import org.example.session07.bai01.model.RestaurantProfile;
import org.example.session07.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping
public class RestauranController {
        @PostMapping("/merchant/update-profile")
        public String updateProfile(RestaurantProfile profile){
            System.out.println("Tên quán: " + profile.getName());
            return "success";

        }

}
