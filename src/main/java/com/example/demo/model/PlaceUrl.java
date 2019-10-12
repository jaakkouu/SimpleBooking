package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="placeUrls")
public class PlaceUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    
    @Column(name="url", nullable=false, updatable=true, unique=true)
	private String url;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="placeId")
    private Place place;

    public PlaceUrl(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String placeName) {
        this.url = generateUrl(placeName);
    }

    private String generateUrl(String placeName) {
        String url = placeName.replace(" ","-").toLowerCase();
        return url;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

}