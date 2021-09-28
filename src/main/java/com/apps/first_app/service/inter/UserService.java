package com.apps.first_app.service.inter;

import com.apps.first_app.exception.UserNotFoundException;
import com.apps.first_app.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User getById(Long id);

    void update(User user);

    void delete(Long id);

    void updateResetPasswordToken(String token, String email) throws UserNotFoundException;

    User get(String resetPasswordToken);

    void updatePassword(User user, String newPassword);

    User getByResetPasswordToken(String token);
}
