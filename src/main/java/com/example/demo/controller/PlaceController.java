package com.example.demo.controller;

import com.example.demo.dao.PlaceRepository;
import com.example.demo.dao.PlaceUrlRepository;
import com.example.demo.dao.UserRepository;

import com.example.demo.model.Booking;
import com.example.demo.model.Place;
import com.example.demo.model.PlaceUrl;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceUrlRepository placeUrlRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{url}")
    public String index(@PathVariable String url, Model model, @RequestParam(required = false) boolean editing, @AuthenticationPrincipal UserDetails currentUser) {
        Place place = placeRepository.findByPlaceUrl_Url(url);    
        Booking booking = new Booking();
        booking.setPlace(place);
        if(editing && currentUser != null) {
            User user = userRepository.findUserByUsername(currentUser.getUsername());
            if(place.equals(placeRepository.findByUserIdAndId(user.getId(), place.getId()))) {
                model.addAttribute("editing", editing);
            }
        }
        model.addAttribute("booking", booking);
        return "/booking/index";
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
    public String addPlace(Model model, @ModelAttribute Place place, @AuthenticationPrincipal UserDetails currentUser) {
        PlaceUrl placeUrl = new PlaceUrl();
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        placeUrl.setUrl(place.getName());
        place.setPlaceUrl(placeUrl);
        place.setUserId(user.getId());
        placeUrl.setPlace(place);
        placeRepository.save(place);
        return "redirect:/places";
    }

}