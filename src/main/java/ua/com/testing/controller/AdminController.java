package ua.com.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminPage(Model model) {

        return "admin/admin";
    }
    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {

        return "admin/dashboard";
    }

}

