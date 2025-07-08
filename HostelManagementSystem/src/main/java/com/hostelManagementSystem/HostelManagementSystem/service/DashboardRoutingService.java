package com.hostelManagementSystem.HostelManagementSystem.service;

import com.hostelManagementSystem.HostelManagementSystem.entity.Admin;
import com.hostelManagementSystem.HostelManagementSystem.entity.Student;
import com.hostelManagementSystem.HostelManagementSystem.entity.SubWarden;
import com.hostelManagementSystem.HostelManagementSystem.repository.AdminRepository;
import com.hostelManagementSystem.HostelManagementSystem.repository.StudentRepository;
import com.hostelManagementSystem.HostelManagementSystem.repository.SubWardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class DashboardRoutingService {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private SubWardenRepository subWardenRepo;

    public String getDashboardByEmailAndPassword(String email, String password, Model model) {

        // Student check
        if (studentRepo.findByEmail(email).isPresent()) {
            Student student = studentRepo.findByEmail(email).get();
            if (student.getPassword().equals(password)) {
                model.addAttribute("student", student);
                return "student-dashboard";
            } else {
                model.addAttribute("error", "Incorrect password.");
                return "login";
            }
        }

        // Admin check
        else if (adminRepo.findByEmail(email).isPresent()) {
            Admin admin = adminRepo.findByEmail(email).get();
            if (admin.getPassword().equals(password)) {
                model.addAttribute("admin", admin);
                return "admin-dashboard";
            } else {
                model.addAttribute("error", "Incorrect password.");
                return "login";
            }
        }

        // Subwarden check
        else if (subWardenRepo.findByEmail(email).isPresent()) {
            SubWarden sw = subWardenRepo.findByEmail(email).get();
            if (sw.getPassword().equals(password)) {
                model.addAttribute("subwarden", sw);
                return "subwarden-dashboard";
            } else {
                model.addAttribute("error", "Incorrect password.");
                return "login";
            }
        }

        // No user found
        else {
            model.addAttribute("error", "Invalid email.");
            return "login";
        }
    }
}
