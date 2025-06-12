package com.example.ASS.servlet;

import java.io.*;

import com.example.ASS.entity.ChiTietSanPham;
import com.example.ASS.service.ChiTietSanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.tool.schema.internal.SchemaCreatorImpl;

@WebServlet(name = "ChiTietSanPhamServletServlet", value = {
        "/chi-tiet/hien-thi",
        "/chi-tiet/detaill",
        "/chi-tiet/view-update",
        "/chi-tiet/delete",
        "/chi-tiet/view-add",
})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamService service = new ChiTietSanPhamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDuLieu(request, response);
        }else if (uri.contains("detaill")) {
            this.hienThiDetail(request, response);
        }else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        }else if (uri.contains("delete")) {
            this.xoaDuLieu(request, response);
        }else if (uri.contains("view-add")) {

        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham chiTietSanPham = service.getOne(Long.valueOf(id));
        request.setAttribute("list", chiTietSanPham);
        request.getRequestDispatcher("/Update.jsp").forward(request, response);
    }

    private void xoaDuLieu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChiTietSanPham chiTietSanPham = service.getOne(Long.valueOf(id));
        service.delete(chiTietSanPham);
        response.sendRedirect("/chi-tiet/hien-thi");
    }

    private void hienThiDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham chiTietSanPham = service.getOne(Long.valueOf(id));
        request.setAttribute("listDetail", chiTietSanPham);
        request.getRequestDispatcher("/Detail.jsp").forward(request, response);
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listChiTietSanPham", service.getAll());
        request.getRequestDispatcher("/SanPhamChiTiet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}