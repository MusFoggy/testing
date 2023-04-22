package ua.com.testing.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getPageHome(Model model, HttpServletRequest request) {
        model.addAttribute("hello", "Hello student!");
        model.addAttribute("session", request.getSession());
        return "home";
    }
}
