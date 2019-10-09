package com.example.demo.controller;

import com.example.demo.dao.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/")
    public String view(Model model) {
        model.addAttribute("places", placeRepository.findAll());
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