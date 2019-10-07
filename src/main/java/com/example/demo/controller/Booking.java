package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class Booking {

    @GetMapping("/bookings")
    public String view(Model model) {
        
       
        //model.addAttribute("places", places);
        return "bookings";
    }

}