package ua.com.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    // Обробляє GET-запити для шляху "/admin"
    @GetMapping("/admin")
    public String adminPage(Model model) {
        // Повертає шаблон "admin/admin"
        return "admin/admin";
    }

    // Обробляє GET-запити для шляху "/dashboard"
    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {
        // Повертає шаблон "admin/dashboard"
        return "admin/dashboard";
    }
}
