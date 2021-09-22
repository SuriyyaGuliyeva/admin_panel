package com.apps.first_app.service.impl;

import com.apps.first_app.model.User;
import com.apps.first_app.repository.inter.UserRepository;
import com.apps.first_app.service.inter.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUserToDB(MultipartFile file, String firstName, String lastName, String email, String password) {
        User user = new User();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();

        iterable.forEach(user -> {
            users.add(user);
        });

        return users;
    }

    @Override
    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = user.getPassword();
        String encodedPassword = encoder.encode(rawPassword);
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        User user = null;

        try {
            user = userRepository.findById(id).get();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return user;
    }

    @Override
    public void update(User user) {
        User oldUser = userRepository.findById(user.getId()).get();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = user.getPassword();
        String encodedPassword = encoder.encode(rawPassword);
        user.setPassword(encodedPassword);

        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());

        userRepository.save(oldUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}