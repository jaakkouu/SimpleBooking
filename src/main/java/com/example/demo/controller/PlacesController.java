package com.example.demo.controller;

import com.example.demo.dao.PlaceRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlacesController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/places")
    public String view(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        model.addAttribute("places", placeRepository.findPlacesByUserId(user.getId()));
        return "places";
    }

  

}