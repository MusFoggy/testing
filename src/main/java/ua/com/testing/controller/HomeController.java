package ua.com.testing.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getPageHome(Model model, HttpServletRequest request, Principal principal) {
        if (principal != null) {
            Authentication auth = (Authentication) principal;
            String role = auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse("Unknown role");

            model.addAttribute("hello", "Hello, your role is: " + role);
        } else {
            model.addAttribute("hello", "Hello guest!");
        }
        model.addAttribute("principal", principal);
        return "home";
    }
}


