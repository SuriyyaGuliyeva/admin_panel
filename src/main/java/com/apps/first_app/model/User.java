//package com.apps.first_app.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true, length = 45)
//    private String email;
//
//    @Column(nullable = false, length = 64)
//    private String password;
//
//    @Column(name = "first_name", nullable = false, length = 20)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false, length = 20)
//    private String lastName;
//}