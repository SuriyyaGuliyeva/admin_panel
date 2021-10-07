//package com.apps.first_app.config;
//
//import com.apps.first_app.model.Session;
//import com.apps.first_app.service.inter.SessionService;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class RequestFilter implements Filter {
//    private final SessionService sessionService;
//
//    public RequestFilter(SessionService sessionService) {
//        this.sessionService = sessionService;
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        Session session = sessionService.findActiveSession();
//
//        if (session == null)
//            response.addHeader("Login", "NOT_LOGIN");
//        else response.addHeader("Login", session.getUser().getLogin().name());
//
//        filterChain.doFilter(request, response);
//    }
//}
