package com.example.demo.controller;

import com.example.demo.dao.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Place {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/{url}")
    public String view(@PathVariable String url, Model model) {
        model.addAttribute("place", placeRepository.findByPlaceUrl_Url(url));
        return "place";
    }

}