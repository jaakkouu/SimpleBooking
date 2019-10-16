package com.example.demo.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="placeId")
    private Place place;

    @NotEmpty(message="Please provide an name")
    @Column(name="name", nullable=false)
    private String name;
    
    @NotEmpty(message="Please provide an phonenumber")
    @Column(name="phonenumber", nullable=false)
    private String phoneNumber;
    
    @Column(name="reservationDate", nullable=false)
    private Date reservationDate;

    @Column(name="receiptNumber", nullable=false)
    private String receiptNumber;

    @Column(name="createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
 
    @Column(name="modifiedAt")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @Column(name="removedAt")
    private LocalDateTime removedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

}