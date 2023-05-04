package ua.com.testing.controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.testing.entity.Users;
import ua.com.testing.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        HttpServletRequest request) {
        if (userService.authenticate(username, password)) {
            Users user = userService.findByUsernameAndPassword(username, password).orElse(null);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String name, @RequestParam String surname, @RequestParam String email, Model model) {
        if (userService.userExists(username)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        userService.registerNewUser(username, password, name, surname, email, passwordEncoder);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }

}



