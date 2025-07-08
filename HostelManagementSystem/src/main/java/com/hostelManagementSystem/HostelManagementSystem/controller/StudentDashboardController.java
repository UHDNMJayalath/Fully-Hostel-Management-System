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

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        // session එකෙන් logged-in user email එක ගන්නවා
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            // login නොවූ අය => login page එකට redirect කරන්න (example)
            return "redirect:/login";
        }

        // email එකෙන් student data fetch කරනවා
        Optional<Student> studentOptional = studentRepository.findByEmail(email);

        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "dashboard";  // thymeleaf template name
        } else {
            // email එකට ගැලපෙන student එකක් නැත්තම් error page එකට යන්න
            return "error";  // හෝ වෙනම page එකක්
        }
    }
}
