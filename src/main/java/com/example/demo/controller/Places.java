package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.User;
import com.example.demo.service.IPlaceService;
import com.example.demo.service.IUserService;

@Controller
public class Places {

    @Autowired
    private IPlaceService placeService;

    @Autowired
    private IUserService userService;

    @GetMapping("/places")
    public String view(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userService.getUserByUsername(currentUser.getUsername());
        model.addAttribute("places", placeService.getPlacesByUserId(user.getId()));
        return "places";
    }

}