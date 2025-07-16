package com.hostelManagementSystem.HostelManagementSystem.service;

import com.hostelManagementSystem.HostelManagementSystem.entity.Student;
import com.hostelManagementSystem.HostelManagementSystem.entity.UserRoles;
import com.hostelManagementSystem.HostelManagementSystem.repository.StudentRepository;
import com.hostelManagementSystem.HostelManagementSystem.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class DashboardRoutingService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private UserRolesRepository userRolesRepo;

    public String getDashboardByEmailAndPassword(String email, String password, Model model) {

        // Step 1: Student login (check from student table)
        Optional<Student> studentOpt = studentRepo.findByEmail(email);
        if (studentOpt.isPresent()) {
            if (studentOpt.get().getPassword().equals(password)) {
                model.addAttribute("student", studentOpt.get());
                return "student-dashboard";
            } else {
                model.addAttribute("error", "Incorrect password.");
                return "login";
            }
        }

        // Step 2: Other roles (check from user_roles table)
        Optional<UserRoles> roleOpt = userRolesRepo.findByEmail(email);
        if (roleOpt.isPresent()) {
            UserRoles user = roleOpt.get();
            if (!user.getPassword().equals(password)) {
                model.addAttribute("error", "Incorrect password.");
                return "login";
            }

            String role = user.getRole().toLowerCase();
            switch (role) {
                case "vc": return "vc-dashboard";
                case "student_services_bursar": return "bursar-dashboard";
                case "dean": return "dean-dashboard";
                case "sub warden": return "sub warden-dashboard";
                case "management": return "management-dashboard";
                case "registration": return "registration-dashboard";
                case "director": return "director-dashboard";
                default:
                    model.addAttribute("error", "Invalid role.");
                    return "login";
            }
        }

        // Step 3: No user found
        model.addAttribute("error", "Invalid email.");
        return "login";
    }
}
