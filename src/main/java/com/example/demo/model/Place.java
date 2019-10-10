package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private int id;

    @Column(name="userid")
    private int userId;

    @Column(name="name", nullable=false, unique=true)
    private String name;

    @Column(name="address", nullable=false)
    private String address;

    @Column(name="largedescription", nullable=false)
    private String largeDescription;

    @Column(name="smalldescription", nullable=false)
    private String smallDescription;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
    private PlaceUrl placeUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="placeid")
    private List<Booking> bookings;

    public Place(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}