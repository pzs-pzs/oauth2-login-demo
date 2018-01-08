package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private CustomUserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        userService.registryUser(user);
        return "redirect:/";
    }
}
