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
        model.addAttribute("user", userRepository.findById(place.getUser().getId()).get());
        model.addAttribute(editing ? "place" : "booking", editing ? place : booking);
        model.addAttribute("title", place.getPlaceUrl().getUrl());
        model.addAttribute("title", place.getName());
        model.addAttribute("subtitle", place.getSmallDescription());
        return "place/index";
    }

    @PostMapping("/{url}/edit")
    public String edit(@PathVariable String url, @ModelAttribute Place formPlace, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        Place place = placeRepository.findByUserIdAndId(user.getId(), formPlace.getId());
        if(place != null) {
            place.setAddress(formPlace.getAddress());
            place.setLargeDescription(formPlace.getLargeDescription());
            place.setSmallDescription(formPlace.getSmallDescription());
            placeRepository.save(place);
        }
        return "redirect:"+ place.getPlaceUrl().getUrl();
    }

    @GetMapping("/place/add")
    public String add(Model model) {
        model.addAttribute("place", new Place());
        return "place/add";
    }

    @PostMapping("/place/add")
    public String addPlace(Model model, @ModelAttribute Place place, @AuthenticationPrincipal UserDetails currentUser) {
        PlaceUrl placeUrl = new PlaceUrl();
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        placeUrl.setUrl(place.getName());
        place.setPlaceUrl(placeUrl);
        place.setUser(user);
        placeUrl.setPlace(place);
        // check for existing place name
        if(placeUrlRepository.findByUrl(placeUrl.getUrl()) == null){
            placeRepository.save(place);
            return "redirect:places";
        } else {
            return "place/add";
        }
    }

    @PostMapping("/place/remove")
    public String removePlace(@RequestParam Long placeId, @AuthenticationPrincipal UserDetails currentUser) {
        if(currentUser != null && placeId != null) {
            User user = userRepository.findUserByUsername(currentUser.getUsername());
            Place place = placeRepository.findByUserIdAndId(user.getId(), placeId);
            placeRepository.delete(place);
        }
        return "redirect:places";
    }

}