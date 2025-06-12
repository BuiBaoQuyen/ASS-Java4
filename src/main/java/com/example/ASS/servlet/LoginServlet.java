package com.example.ASS.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response); // Chuyển đến form đăng nhập
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Giả lập kiểm tra đăng nhập
        if ("admin".equals(username) && "123".equals(password)) {
            request.getSession().setAttribute("role", 2); // QuanLy
            response.sendRedirect("/admin");
        } else if ("user".equals(username) && "123".equals(password)) {
            request.getSession().setAttribute("role", 1); // KhachHang
            response.sendRedirect("/client");
        } else {
            request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}