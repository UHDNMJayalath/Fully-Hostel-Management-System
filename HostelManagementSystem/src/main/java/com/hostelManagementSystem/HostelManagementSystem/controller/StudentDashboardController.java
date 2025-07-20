package com.hostelManagementSystem.HostelManagementSystem.controller;

import com.hostelManagementSystem.HostelManagementSystem.entity.Damage;
import com.hostelManagementSystem.HostelManagementSystem.entity.Payment;
import com.hostelManagementSystem.HostelManagementSystem.entity.Residence;
import com.hostelManagementSystem.HostelManagementSystem.entity.Student;
import com.hostelManagementSystem.HostelManagementSystem.repository.DamageRepository;
import com.hostelManagementSystem.HostelManagementSystem.repository.PaymentRepository;
import com.hostelManagementSystem.HostelManagementSystem.repository.ResidenceRepository;
import com.hostelManagementSystem.HostelManagementSystem.repository.StudentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
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

        Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(email);

        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "/student-dashboard";
        } else {

            return "error";
        }
    }




    @Autowired
    private ResidenceRepository residenceRepository;

    @GetMapping("/Student_History_Residence")
    public String studentHistory(HttpSession session, Model model) {
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(email);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            model.addAttribute("student", student);

            List<Residence> residenceList = residenceRepository.findByStudent(student);
            model.addAttribute("residences", residenceList); // ✅ Data pass

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

        Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(email);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "Student_ComplainsAndRequests"; // <-- Thymeleaf HTML file name
        } else {
            return "error";
        }
    }


    @Autowired
    private PaymentRepository paymentRepository;


    @GetMapping("/Student_History_Payment")
    public String paymentPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(email);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            model.addAttribute("student", student);

            List<Payment> payments = paymentRepository.findByStudent(student);
            model.addAttribute("payments", payments); // <-- IMPORTANT!

            return "Student_History_Payment";
        } else {
            return "error";
        }
    }



    @Autowired
    private DamageRepository damageRepository;

    @GetMapping("/Student_History_Damage")
    public String damagePage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("loggedInUserEmail");

        if (email == null) {
            return "redirect:/login";
        }

        Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(email);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            model.addAttribute("student", student);

            List<Damage> damages = damageRepository.findByStudent(student);
            model.addAttribute("damages", damages); // ✅ send to view

            return "Student_History_Damage";
        } else {
            return "error";
        }
    }








}
