package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findBookingsByPlaceId(Long placeId);
}