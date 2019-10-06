package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/")
    public String view(Model model) {
        ArrayList<String> places = new ArrayList<String>();
        places.add("Dinner at Sea Restaurant");
        places.add("Benji Jump experience");
        places.add("Private Dolphin Safari");
        places.add("Breakfast at Tower");
        places.add("Aqua Vacation at Bali");
        model.addAttribute("places", places);
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