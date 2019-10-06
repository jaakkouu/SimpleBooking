package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Booking {

    @GetMapping("/bookings")
    public String view() {
        return "bookings";
    }

}