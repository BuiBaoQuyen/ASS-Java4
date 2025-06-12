package com.example.ASS.repository;

import com.example.ASS.entity.ChiTietSanPham;
import com.example.ASS.until.HibernateUntil;
import org.hibernate.Session;

import java.util.List;

public class ChiTietSanPhamRepo {
    private Session s;

    public ChiTietSanPhamRepo() {
        s = HibernateUntil.getFACTORY().openSession();
    }

    public List<ChiTietSanPham> getAll(){
        return s.createQuery("from ChiTietSanPham ").list();
    }

    public ChiTietSanPham getOne(Long id){
        return s.find(ChiTietSanPham.class, id);
    }

    public void delete(ChiTietSanPham chiTietSanPham){
        try {
            s.getTransaction().begin();
            s.delete(chiTietSanPham);
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void update(ChiTietSanPham chiTietSanPham){
        try {
            s.getTransaction().begin();
            s.merge(chiTietSanPham);
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void add(ChiTietSanPham chiTietSanPham){
        try {
            s.getTransaction().begin();
            s.persist(chiTietSanPham);
            s.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
}
