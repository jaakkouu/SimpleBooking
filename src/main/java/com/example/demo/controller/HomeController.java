package com.example.demo.controller;

import com.example.demo.dao.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("places", placeRepository.findAll());
        return "index";
    }
   
}