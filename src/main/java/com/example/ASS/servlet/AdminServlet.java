package com.example.ASS.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Kiểm tra role (sẽ tích hợp với Filter sau)
        Integer role = (Integer) request.getSession().getAttribute("role");
        if (role == null || role != 2) { // 2: QuanLy
            response.sendRedirect("/login");
            return;
        }

        // Giả lập dữ liệu sản phẩm
        request.setAttribute("products", "Sản phẩm 1, Sản phẩm 2"); // Dữ liệu giả lập
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        // Giả lập CRUD
        if ("add".equals(action)) {
            // Logic thêm (giả lập)
            response.getWriter().write("Thêm thành công: " + ma + ", " + ten);
        } else if ("update".equals(action)) {
            // Logic sửa
            response.getWriter().write("Sửa thành công: " + ma + ", " + ten);
        } else if ("delete".equals(action)) {
            // Logic xóa
            response.getWriter().write("Xóa thành công: " + ma);
        }
        doGet(request, response); // Quay lại trang
    }
}