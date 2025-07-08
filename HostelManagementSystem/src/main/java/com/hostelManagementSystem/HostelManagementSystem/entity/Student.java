package com.hostelManagementSystem.HostelManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id

    private String studentId;
    private String name;
    private String email;
    private String password;
    private String currentHostel;
    private String faculty;
    private String intake;
    private String distance;
    private String address;
    private String contact;
    private String emergencyContact;

    public Student() {
        // Default constructor required by JPA
    }

    public Student(String studentId, String name, String email, String password, String currentHostel, String faculty, String intake, String distance, String address, String contact, String emergencyContact) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.currentHostel = currentHostel;
        this.faculty = faculty;
        this.intake = intake;
        this.distance = distance;
        this.address = address;
        this.contact = contact;
        this.emergencyContact = emergencyContact;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getCurrentHostel() {
        return currentHostel;
    }

    public void setCurrentHostel(String currentHostel) {
        this.currentHostel = currentHostel;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getIntake() {
        return intake;
    }

    public void setIntake(String intake) {
        this.intake = intake;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}
