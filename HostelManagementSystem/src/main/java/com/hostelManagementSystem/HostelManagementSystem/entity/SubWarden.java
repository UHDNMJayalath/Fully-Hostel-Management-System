package com.hostelManagementSystem.HostelManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SubWarden {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String hostel;

    public SubWarden() {

    }

    public SubWarden(Long id, String name, String email, String password, String hostel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.hostel = hostel;
    }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }
}
