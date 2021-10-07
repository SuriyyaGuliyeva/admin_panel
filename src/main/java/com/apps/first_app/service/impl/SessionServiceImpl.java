//package com.apps.first_app.service.impl;
//
//import com.apps.first_app.model.Session;
//import com.apps.first_app.model.User;
//import com.apps.first_app.repository.inter.SessionRepository;
//import com.apps.first_app.service.inter.SessionService;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class SessionServiceImpl implements SessionService {
//    private final SessionRepository sessionRepository;
//
//    public SessionServiceImpl(SessionRepository sessionRepository) {
//        this.sessionRepository = sessionRepository;
//    }
//
//    @Override
//    public Session findActiveSession() {
//        List<Session> sessions = sessionRepository.findAll();
//        if (sessions.isEmpty()) return null;
//        return sessions.get(0);
//    }
//
//    @Override
//    public void createSession(User user) {
//        Session session = Session
//                .builder()
//                .sessionId(UUID.randomUUID().toString())
//                .user(user)
//                .createdAt(LocalDateTime.now())
//                .build();
//        sessionRepository.save(session);
//    }
//
//    @Override
//    public void deleteAll() {
//        sessionRepository.deleteAll();
//    }
//}
