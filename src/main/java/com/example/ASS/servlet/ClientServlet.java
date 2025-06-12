package com.example.ASS.servlet;

import com.example.ASS.entity.GioHang;
import com.example.ASS.entity.HoaDon;
import com.example.ASS.entity.SanPham;
import com.example.ASS.until.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    private static final String CART_ATTRIBUTE = "cart";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách sản phẩm từ cơ sở dữ liệu
        Session session = HibernateUntil.getFACTORY().openSession();
        try {
            session.beginTransaction();
            Query<SanPham> query = session.createQuery("FROM SanPham", SanPham.class);
            List<SanPham> products = query.list();
            session.getTransaction().commit();

            request.setAttribute("products", products); // Truyền danh sách sản phẩm
            request.getRequestDispatcher("/client/index.jsp").forward(request, response);
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            response.getWriter().write("Lỗi khi lấy sản phẩm: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String productId = request.getParameter("productId"); // Giả sử dùng ID sản phẩm
        String quantity = request.getParameter("quantity");
        String maHoaDon = request.getParameter("maHoaDon");

        Session session = HibernateUntil.getFACTORY().openSession();
        List<String> cart = (List<String>) request.getSession().getAttribute(CART_ATTRIBUTE);
        if (cart == null) {
            cart = new ArrayList<>();
            request.getSession().setAttribute(CART_ATTRIBUTE, cart);
        }

        String message = "";
        try {
            session.beginTransaction();

            if ("addToCart".equals(action)) {
                if (productId != null && !productId.isEmpty() && quantity != null && !quantity.isEmpty()) {
                    // Giả lập thêm vào giỏ (thực tế cần liên kết với GioHang)
                    SanPham product = session.get(SanPham.class, Integer.parseInt(productId));
                    if (product != null) {
                        cart.add(product.getTen() + " (Số lượng: " + quantity + ")");
                        message = "Thêm vào giỏ thành công: " + product.getTen() + ", Số lượng: " + quantity;
                    } else {
                        message = "Sản phẩm không tồn tại!";
                    }
                } else {
                    message = "Vui lòng nhập sản phẩm và số lượng!";
                }
            } else if ("checkout".equals(action)) {
                if (!cart.isEmpty()) {
                    // Tạo hóa đơn mới
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setMa("HD" + System.currentTimeMillis()); // Giả lập mã
                    hoaDon.setNgayTao(new java.util.Date());
                    session.save(hoaDon);
                    request.getSession().setAttribute("lastInvoice", hoaDon.getMa());
                    cart.clear();
                    message = "Thanh toán thành công. Mã hóa đơn: " + hoaDon.getMa();
                } else {
                    message = "Giỏ hàng trống!";
                }
            } else if ("track".equals(action)) {
                // Tra cứu hóa đơn
                Query<HoaDon> query = session.createQuery("FROM HoaDon WHERE ma = :ma", HoaDon.class);
                query.setParameter("ma", maHoaDon);
                HoaDon hoaDon = query.uniqueResult();
                if (hoaDon != null) {
                    message = "Tra cứu thành công: Mã " + hoaDon.getMa() + ", Ngày tạo: " + hoaDon.getNgayTao();
                } else {
                    message = "Mã hóa đơn không đúng hoặc không tìm thấy!";
                }
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            message = "Lỗi: " + e.getMessage();
        } finally {
            session.close();
        }

        request.setAttribute("message", message); // Gửi thông báo
        doGet(request, response); // Quay lại trang
    }
}