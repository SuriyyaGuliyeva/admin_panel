package com.apps.first_app.controller;

import com.apps.first_app.model.Department;
import com.apps.first_app.model.User;
import com.apps.first_app.service.inter.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String allUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("addUser", new User());
        return "users/addUser";
    }

    @PostMapping("/newUser")
    public String newUser(@RequestParam("file") MultipartFile file,
                          @RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password) {
        userService.saveUserToDB(file, firstName, lastName, email, password);
        return "redirect:/users/list";

//        userService.save(user);
//        return "redirect:/users/list";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam("id") Long id) {
       User user = userService.getById(id);

       if (user == null) {
           return "commonPages/notFoundPage";
       } else {
           model.addAttribute("editedUser", user);
           return "users/editedUser";
       }
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users/list";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute User user, @RequestParam("id") Long id) {
        userService.delete(user.getId());
        return "redirect:/users/list";
    }

}