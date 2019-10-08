package com.example.demo.controller;

import com.example.demo.service.IPlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @Autowired
    private IPlaceService placeService;

    @GetMapping("/")
    public String view(Model model) {
        model.addAttribute("places", placeService.getPlaces());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

   
}