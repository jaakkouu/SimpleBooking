package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import com.example.demo.model.Booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    Booking findBookingByReceiptNumber(String receiptNumber);
    List<Booking> findBookingsByPlaceId(Long placeId);
}