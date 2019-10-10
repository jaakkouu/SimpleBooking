package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Profile {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/profile")
    public String index(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userRepository.getUserByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile/company")
    public String saveCompany(@ModelAttribute User user) {
        return "profile";
    }
    @PostMapping("/profile/billing")
    public String saveBilling(@ModelAttribute User user) {
        return "profile";
    }
    @PostMapping("/profile/contact")
    public String saveContact(@ModelAttribute User user) {
        return "profile";
    }

}