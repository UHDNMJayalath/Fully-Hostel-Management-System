package com.hostelManagementSystem.HostelManagementSystem.controller;

import com.hostelManagementSystem.HostelManagementSystem.service.DashboardRoutingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private DashboardRoutingService dashboardRoutingService;

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        session.setAttribute("loggedInUserEmail", email);

        return dashboardRoutingService.getDashboardByEmailAndPassword(email, password, model);
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }






}
