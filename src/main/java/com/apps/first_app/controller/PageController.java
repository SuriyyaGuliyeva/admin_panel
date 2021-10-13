package com.apps.first_app.controller;

//import com.apps.first_app.model.User;
//import com.apps.first_app.repository.inter.UserRepository;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Slf4j
@Controller
public class PageController {

//    private final UserRepository userRepository;

//    public PageController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping({"", "/home"})
    public String homePage() {
        return "common/index";
    }

//    @GetMapping("/register")
//    public String showSignUpForm(Model model) {
//        model.addAttribute("user", new User());
//
//        return "register/signupForm";
//
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
////            return "register/signupForm";
////        }
////        return "redirect:/";
//    }

    /*@PostMapping("/process_register")
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
    }*/

}