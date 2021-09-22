package com.apps.first_app.service.inter;

import com.apps.first_app.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User getById(Long id);

    void update(User user);

    void delete(Long id);

    void saveUserToDB(MultipartFile file, String firstName, String lastName, String email, String password);
}
