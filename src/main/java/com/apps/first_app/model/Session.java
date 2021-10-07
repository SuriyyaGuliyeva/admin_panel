//package com.apps.first_app.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "sessions")
//public class Session {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "session_id")
//    private String sessionId;
//    @OneToOne(cascade=CascadeType.ALL)
//    private User user;
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//}
