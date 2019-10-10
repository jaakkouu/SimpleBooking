package com.example.demo.controller;

import com.example.demo.dao.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Place {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/{url}")
    public String index(@PathVariable String url, Model model) {
        model.addAttribute("place", placeRepository.findByPlaceUrl_Url(url));
        return "/place/index";
    }

    @GetMapping("/{url}/edit")
    public String edit(@PathVariable String url, Model model) {
        model.addAttribute("place", placeRepository.findByPlaceUrl_Url(url));
        return "/place/edit";
    }

    @GetMapping("/place/add")
    public String add(Model model) {
        model.addAttribute("place", new Place());
        return "/place/add";
    }

    @PostMapping("/place/add")
    public String addPlace(@ModelAttribute Place place) {
        return "/places";
    }

}