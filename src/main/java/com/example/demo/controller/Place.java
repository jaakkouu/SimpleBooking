package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Place {

    @GetMapping("/place/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("place", "My imaginery place: " + id);
        return "place";
    }

}