//package com.apps.first_app.controller;
//
//import com.apps.first_app.exception.UserNotFoundException;
//import com.apps.first_app.model.User;
//import com.apps.first_app.service.inter.UserService;
//import com.apps.first_app.utils.Utility;
//import net.bytebuddy.utility.RandomString;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.http.HttpServletRequest;
//import java.io.UnsupportedEncodingException;
//
//@Controller
//public class ForgotPasswordController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private JavaMailSender mailSender;
//
////    public ForgotPasswordController(UserService userService, JavaMailSender mailSender) {
////        this.userService = userService;
////        this.mailSender = mailSender;
////    }
//
//    @GetMapping("/forgot-password")
//    public String showForgotPasswordForm(Model model) {
//        model.addAttribute("forgotPasswordForm", "Forgot Password");
//        return "register/forgotPasswordForm";
//    }
//
//    @PostMapping("/forgot-password")
//    public String processForgotPasswordForm(HttpServletRequest request, Model model) {
//        String email = request.getParameter("email");
//        String token = RandomString.make(45);
//
//        try {
//            userService.updateResetPasswordToken(token, email);
//
//            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
//            sendEmail(email, resetPasswordLink);
//
//            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
//        } catch (UserNotFoundException e) {
//            model.addAttribute("error", e.getMessage());
//        } catch (UnsupportedEncodingException | MessagingException e) {
//            model.addAttribute("error", "Error while sending email.");
//        }
//
//        model.addAttribute("forgotPasswordForm", "Forgot Password");
//        return "register/forgotPasswordForm";
//    }
//
//    private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        helper.setFrom("suriyya.work@gmail.com", "Support");
//        helper.setTo(email);
//
//        String subject = "Here's the link to reset your password";
//        String content = "<p>Hello,</p>"
//                + "<p>You have requested to reset your password.</p>"
//                + "<p>Click the link below to change your password:</p>"
//                + "<p><b><a href=\"" + resetPasswordLink + "\">Change my password</a></b></p>"
//                + "<br>"
//                + "<p>Ignore this email if you do remember your password, "
//                + "or you have not made the request.</p>";
//
//        helper.setSubject(subject);
//        helper.setText(content, true);
//
//        mailSender.send(message);
//    }
//
//    @GetMapping("/reset_password")
//    public String showResetPasswordForm(@Param(value="token") String token, Model model) {
//        User user = userService.get(token);
//
//        if (user == null) {
//            model.addAttribute("title", "Reset your password");
//            model.addAttribute("message", "Invalid token");
//            return "message";
//        }
//
//        model.addAttribute("token", token);
//        model.addAttribute("pageTitle", "Reset Your Password");
//        return "resetPasswordForm";
//    }
//
//    @PostMapping("/reset_password")
//    public String processResetPassword(HttpServletRequest request, Model model) {
//        String token = request.getParameter("token");
//        String password = request.getParameter("password");
//
//        User user = userService.get(token);
//
//        if (user == null) {
//            model.addAttribute("title", "Reset your password");
//            model.addAttribute("message", "Invalid Token");
//        } else {
//            userService.updatePassword(user, password);
//            model.addAttribute("message", "You have successfully changed your password.");
//        }
//        return "message";
//    }
//}
//
//
