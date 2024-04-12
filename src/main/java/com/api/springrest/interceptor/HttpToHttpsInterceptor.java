package com.api.springrest.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpToHttpsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getServerPort() == 80) {
            String redirectUrl = "https://" + request.getServerName() + request.getRequestURI();
            response.sendRedirect(redirectUrl);
            return false;
        }
        return true;
    }
}
