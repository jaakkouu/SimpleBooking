package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.dao.BookingRepository;
import com.example.demo.dao.PlaceRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Booking;
import com.example.demo.model.Place;
import com.example.demo.model.Receipt;
import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ResponseBody
    @PostMapping("/booking/check")
    public String check(@RequestParam(value = "reservationNumber") String rN, HttpServletRequest request, HttpServletResponse response, Model model) throws JsonProcessingException {
        Booking booking = bookingRepository.findBookingByReceiptNumber(rN);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode obj = mapper.createObjectNode();
        if(booking != null) {
            ObjectNode bookingObj = mapper.createObjectNode();
            bookingObj.put("orderer", booking.getName());
            bookingObj.put("phoneNumber", booking.getPhoneNumber());
            bookingObj.put("reservation", booking.getPlace().getName());
            bookingObj.put("address", booking.getPlace().getAddress());
            bookingObj.put("reservationDate", booking.getReservationDate().toString());
            obj.put("status", true);
            obj.put("reservation", bookingObj.toString());
        } else {
            obj.put("status", false);
        }
        return obj.toString();
    }

    @GetMapping("/booking/success")
    public String bookingSuccess(Model model) {
        return model.asMap().get("receipt") != null ? "/booking/success" : "redirect:/";
    }

    @PostMapping("/booking/add")
    public String book(Model model, @ModelAttribute Booking booking, RedirectAttributes redirectAttributes) {
        Place place = placeRepository.findById(booking.getPlace().getId()).get();
        Receipt receipt = new Receipt(booking.getName(), place.getName(), booking.getPhoneNumber(), booking.getReservationDate());
        booking.setReceiptNumber(receipt.getReceiptNumber());
        bookingRepository.save(booking);
        redirectAttributes.addFlashAttribute("receipt", receipt);
        return "redirect:/booking/success";
    }


}