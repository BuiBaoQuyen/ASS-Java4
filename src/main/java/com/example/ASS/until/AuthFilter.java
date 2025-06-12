package com.example.ASS.until;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();

        // Lấy role từ session
        Integer role = (Integer) httpRequest.getSession().getAttribute("role");

        // Không yêu cầu đăng nhập cho trang login và client
        if (uri.endsWith("/login") || uri.contains("/client")) {
            chain.doFilter(request, response);
            return;
        }

        // Yêu cầu đăng nhập và role QuanLy cho trang admin
        if (uri.contains("/admin")) {
            if (role == null) {
                httpResponse.sendRedirect("/login");
            } else if (role != 2) { // 2: QuanLy
                httpResponse.sendRedirect("/access-denied.jsp"); // Tạo file này sau
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}