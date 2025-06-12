package com.example.ASS.servlet;

import java.io.*;

import com.example.ASS.service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SanPhamServletServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/hien-thi-chi-tiet"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamService service = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDuLieu(request, response);
        }else if (uri.contains("hien-thi-chi-tiet")) {
            this.hienThiChiTiet(request, response);
        }
    }

    private void hienThiChiTiet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/SanPhamChiTiet.jsp");
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSanPham", service.getAll());
        request.getRequestDispatcher("/SanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}