package com.hostelManagementSystem.HostelManagementSystem.entity;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private double amount;
    private String type;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Payment(Long id, String date, double amount, String type, Student student) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.student = student;
    }

    public Payment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

