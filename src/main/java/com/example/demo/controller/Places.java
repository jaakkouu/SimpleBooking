package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Place;

@Controller
public class Places {

    @GetMapping("/places")
    public String view(Model model) {
        List<Place> places = new ArrayList<Place>();
        places.add(new Place("Sea Food Restaurant", "Random Road 32", "Lorem ipsum dolor sit amet", "Lorem ipsum"));
        places.add(new Place("Tower Restaraunt", "Random Road 16", "Lorem ipsum dolor sit amet", "Lorem ipsum"));
        places.add(new Place("Downtown Chinese", "Random Dead End 79", "Lorem ipsum dolor sit amet", "Lorem ipsum"));
        model.addAttribute("places", places);
        return "places";
    }

}