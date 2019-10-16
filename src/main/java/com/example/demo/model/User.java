package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @NotEmpty(message="Please provide an username")
    @Column(name="username", updatable=false, nullable=false, unique=true)
    private String username;

    @NotEmpty(message="Please provide an email address")
    @Column(name="email", updatable=false, nullable=false, unique=true)
    private String email;
    
    @NotEmpty(message="Please provide an password")
    @Column(name="password", updatable=false, nullable=false)
    private String password;

    @Column(name="enabled", nullable=false)
    private int enabled;
    
    @Column(name="createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
 
    @Column(name="modifiedAt")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @Column(name="removedAt")
    private LocalDateTime removedAt;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
    private Role role;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
    private Company company;
    
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
    private Contact contact;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
    private List<Place> places;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public void setEmail(String email) {
        this.email = email;
	}

    public String getEmail() {
        return this.email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

}