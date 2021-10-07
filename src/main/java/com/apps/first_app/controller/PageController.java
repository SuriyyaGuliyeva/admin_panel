package com.apps.first_app.controller;

import com.apps.first_app.model.User;
import com.apps.first_app.repository.inter.UserRepository;
//import com.apps.first_app.service.inter.SessionService;
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

//    private final SessionService sessionService;
    private final UserRepository userRepository;

    public PageController(UserRepository userRepository) {
//        this.sessionService = sessionService;
        this.userRepository = userRepository;
    }

    @GetMapping({"", "/home"})
    public String homePage() {
        return "common/index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());

        // bu kodun register ucun duzgunluyunden emin ol
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "register/signupForm";
        }
        return "redirect:/";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
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