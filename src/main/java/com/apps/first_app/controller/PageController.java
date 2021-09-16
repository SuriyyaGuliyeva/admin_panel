package com.apps.first_app.controller;

import com.apps.first_app.model.User;
import com.apps.first_app.repository.inter.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

//    @GetMapping("/homePage")
//    public String homePage() {
//        return "commonPages/homePage";
//    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());

        // bu kodun register ucun duzgunluyunden emin ol
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "commonPages/signupForm";
        }
        return "redirect:/";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "register/login";
        }
        return "redirect:/";
    }
}














