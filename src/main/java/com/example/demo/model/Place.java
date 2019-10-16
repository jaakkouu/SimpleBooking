package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @NotEmpty(message="Please provide an name")
    @Column(name="name", nullable=false, unique=true)
    private String name;

    @NotEmpty(message="Please provide an address")
    @Column(name="address", nullable=false)
    private String address;

    @NotEmpty(message="Please provide large description")
    @Column(name="largeDescription", nullable=false)
    private String largeDescription;

    @NotEmpty(message="Please provide small description")
    @Column(name="smallDescription", nullable=false)
    private String smallDescription;
    
    @Column(name="createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
 
    @Column(name="modifiedAt")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @Column(name="removedAt")
    private LocalDateTime removedAt;

    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="place")
	public PlaceUrl placeUrl;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="place")
    private List<Booking> bookings;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    public Place(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getActiveBookings() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        dateFormat.format(currentDate);
        int numberOfActiveBookings = 0;
        for(Booking booking : bookings){
            Date x = booking.getReservationDate();
            if(x.after(currentDate) || x.equals(currentDate)){
                numberOfActiveBookings++;
            }
        }
        return numberOfActiveBookings;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(LocalDateTime removedAt) {
        this.removedAt = removedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}