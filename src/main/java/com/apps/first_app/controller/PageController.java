package com.apps.first_app.controller;

import com.apps.first_app.model.User;
import com.apps.first_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final UserRepository repo;

    public PageController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "commonPages/index";
    }

    @GetMapping("/homePage")
    public String homePage() {
        return "commonPages/homePage";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "commonPages/signupForm";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);
        return "registerOrLogin/registerSuccess";
    }
}