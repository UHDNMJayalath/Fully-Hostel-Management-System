package com.hostelManagementSystem.HostelManagementSystem.controller;

import com.hostelManagementSystem.HostelManagementSystem.entity.Student;
import com.hostelManagementSystem.HostelManagementSystem.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class StudentDashboardController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student-dashboard")
    public String dashboard(HttpSession session, Model model) {

        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {

            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmail(email);

        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "/student-dashboard";
        } else {

            return "error";
        }
    }




    @GetMapping("/Student_History_Residence")
    public String studentHistory(HttpSession session, Model model) {
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmail(email);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "Student_History_Residence";
        } else {
            return "error";
        }
    }


    @GetMapping("Student_ComplainsAndRequests")
    public String studentComplaints(HttpSession session, Model model) {
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmail(email);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "Student_ComplainsAndRequests"; // <-- Thymeleaf HTML file name
        } else {
            return "error";
        }
    }


    @GetMapping("/Student_History_Payment")
    public String paymentPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmail(email);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "Student_History_Payment"; // <- this is your .html page
        } else {
            return "error";
        }
    }


    @GetMapping("/Student_History_Damage")
    public String damagePage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmail(email);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "Student_History_Damage"; // <- your .html file name
        } else {
            return "error";
        }
    }







}
