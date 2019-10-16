package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.Company;
import com.example.demo.model.Contact;
import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String view(Model model) {
        model.addAttribute("users", userRepository.findByRole_AuthorityNot("ROLE_ADMIN"));
        return "users";
    }

    @ResponseBody
    @PostMapping("/user/activate") 
    public String activate(@RequestParam Long userId, @AuthenticationPrincipal UserDetails currentUser) {
        User activator = userRepository.findByUsername(currentUser.getUsername());
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode obj = mapper.createObjectNode();
        obj.put("status", "false");
        if(activator.getRole().getAuthority() == "ROLE_ADMIN"){
            User user = userRepository.findById(userId).get();
            user.setEnabled(1);
            userRepository.save(user);
            obj.put("status", "true");
        }
        return obj.toString();
    }

    @ResponseBody
    @PostMapping("/user/remove") 
    public String remove(@RequestParam Long userId, @AuthenticationPrincipal UserDetails currentUser) {
        User remover = userRepository.findByUsername(currentUser.getUsername());
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode obj = mapper.createObjectNode();
        obj.put("status", "false");
        if(remover.getRole().getAuthority() == "ROLE_ADMIN"){
            userRepository.deleteById(userId);
            obj.put("status", "true");
        }
        return obj.toString();
    }
    
    @GetMapping("/profile")
    public String index(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        model.addAttribute("user", user);
        return "/profile";
    }

    @PostMapping("/profile")
    public String save(Model model, @ModelAttribute User formUser, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        Company company = formUser.getCompany();
        Contact contact = formUser.getContact();
        company.setUser(user);
        contact.setUser(user);
        user.setCompany(company);
        user.setContact(contact);
        userRepository.save(user);
        return "redirect:/profile";
    }

}