package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @Column(name="userId")
    private Long userId;

    @Column(name="name", nullable=false, unique=true)
    private String name;

    @Column(name="address", nullable=false)
    private String address;

    @Column(name="largeDescription", nullable=false)
    private String largeDescription;

    @Column(name="smallDescription", nullable=false)
    private String smallDescription;

    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="place")
	public PlaceUrl placeUrl;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="place")
    private List<Booking> bookings;

    public Place(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLargeDescription() {
        return largeDescription;
    }

    public void setLargeDescription(String largeDescription) {
        this.largeDescription = largeDescription;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }

    public PlaceUrl getPlaceUrl() {
        return placeUrl;
    }

    public void setPlaceUrl(PlaceUrl placeUrl) {
        this.placeUrl = placeUrl;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    private void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<String> getBookedDates() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        List<String> bookedDates = new ArrayList<String>();
        for(Booking booking : bookings){
            String reservationDate =  dateFormat.format(booking.getReservationDate());
            bookedDates.add(reservationDate);
        }
        return bookedDates;
    }

    

}