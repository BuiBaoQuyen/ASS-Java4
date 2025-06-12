package com.example.ASS.repository;

import com.example.ASS.entity.SanPham;
import com.example.ASS.until.HibernateUntil;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepo {
    private Session s;

    public SanPhamRepo() {
        s = HibernateUntil.getFACTORY().openSession();
    }

    public List<SanPham> getAll() {
        return s.createQuery("from SanPham ").list();
    }

    public SanPham getOne(Long id) {
        return s.find(SanPham.class, id);
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamRepo().getAll());
    }
}
