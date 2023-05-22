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
        // Перевірка, чи існує автентифікований користувач (principal)
        if (principal != null) {
            // Отримання об'єкта аутентифікації користувача
            Authentication auth = (Authentication) principal;

            // Отримання ролі користувача з об'єкта аутентифікації
            String role = auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse("Невідома роль");

            // Додавання повідомлення з роллю користувача в модель
            model.addAttribute("hello", "Привіт, ваша роль: " + role);
        } else {
            // Якщо користувач не автентифікований, додати повідомлення для гостя
            model.addAttribute("hello", "Привіт, гість!");
        }

        // Додавання об'єкту principal в модель
        model.addAttribute("principal", principal);

        // Повернення назви шаблону "home" для відображення
        return "home";
    }
}



