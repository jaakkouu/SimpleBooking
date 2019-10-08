package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name="userId", nullable = false, updatable = false)
    private Long userId;

    @Column(name="name", nullable = false, unique = true)
    private String name;
    
    @Column(name="address", nullable = false)
    private String address;

    @Column(name="largeDescription", nullable = false)
    private String largeDescription;

    @Column(name="smallDescription", nullable = false)
    private String smallDescription;
    
    public Place(){

    }

    public Place(long userId, String name, String address, String largeDescription, String smallDescription){
        super();
        setUserId(userId);
        setName(name);
        setAddress(address);
        setLargeDescription(largeDescription);
        setSmallDescription(smallDescription);
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
}