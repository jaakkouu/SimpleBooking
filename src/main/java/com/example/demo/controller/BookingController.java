package com.example.demo.controller;

import com.example.demo.dao.BookingRepository;
import com.example.demo.dao.PlaceRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Booking;
import com.example.demo.model.Place;
import com.example.demo.model.Receipt;
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
public class BookingController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public String view(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userRepository.findUserByUsername(currentUser.getUsername());
        model.addAttribute("places", placeRepository.findPlacesByUserId(user.getId()));
        return "bookings";
    }

    @PostMapping("/booking/add")
    public String book(Model model, @ModelAttribute Booking booking) {
        Place place = placeRepository.findById(booking.getPlaceId()).get();
        Receipt receipt = new Receipt(booking.getName(), place.getName(), booking.getPhoneNumber(), booking.getReservationDate());
        booking.setReceiptNumber(receipt.getReceiptNumber());
        bookingRepository.save(booking);
        model.addAttribute("receipt", receipt);
        return "/booking/success";
    }


}