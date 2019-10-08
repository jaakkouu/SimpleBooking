package com.example.demo.controller;

import com.example.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Profile {

    @Autowired
    private IUserService userService;

    @GetMapping("/profile")
    public String view(Model model) {
        model.addAttribute("user", userService.getUserByUsername("admin"));
        return "profile";
    }

}