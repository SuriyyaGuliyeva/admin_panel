package com.apps.first_app.controller;

import com.apps.first_app.model.User;
import com.apps.first_app.service.inter.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

//    @PostMapping("/newUser")
//    public String newUser(@ModelAttribute User user,
//                          @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
//
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//
//        user.setPhoto(fileName);
//        User savedUser = userService.save(user);
//
//        String uploadDir = "./user-photos/" + savedUser.getId();
//        Path uploadPath = Paths.get(uploadDir);
//
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        try (InputStream inputStream = multipartFile.getInputStream()) {
//            Path filePath = uploadPath.resolve(fileName);
//
////            System.out.println(filePath.toString());
//
//            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new IOException("Couldn't save uploaded file: " + fileName);
//        }
//
//        return "redirect:/users/list";
//    }

    @PostMapping("/newUser")
    public String newUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam("id") Long id) {
        User user = userService.getById(id);

        if (user == null) {
            return "common/notFoundPage";
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