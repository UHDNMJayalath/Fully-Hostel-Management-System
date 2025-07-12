package com.hostelManagementSystem.HostelManagementSystem.entity;

import jakarta.persistence.*;

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // "Complaint" or "Request"
    private String receiver; // "Sub Warden", "Accommodation Director"
    private String description;
    private String submittedDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Complaint(Long id, String type, String receiver, String description, String submittedDate, Student student) {
        this.id = id;
        this.type = type;
        this.receiver = receiver;
        this.description = description;
        this.submittedDate = submittedDate;
        this.student = student;
    }

    public Complaint() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

