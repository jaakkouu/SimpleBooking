package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.IUsersService;


@Controller
public class Users {

    @Autowired
    private IUsersService usersService;

    @GetMapping("/users")
    public String view(Model model) {
        model.addAttribute("users", usersService.getUsers());
        return "users";
    }

}