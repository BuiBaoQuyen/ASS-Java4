package com.example.ASS.service;

import com.example.ASS.entity.ChiTietSanPham;
import com.example.ASS.repository.ChiTietSanPhamRepo;

import java.util.List;

public class ChiTietSanPhamService {
    private ChiTietSanPhamRepo repo = new ChiTietSanPhamRepo();
    public List<ChiTietSanPham> getAll(){
        return repo.getAll();
    }
    public ChiTietSanPham getOne(Long id){
        return repo.getOne(id);
    }

    public void delete(ChiTietSanPham chiTietSanPham){
        repo.delete(chiTietSanPham);
    }

    public void update(ChiTietSanPham chiTietSanPham){
        repo.update(chiTietSanPham);
    }

    public void add(ChiTietSanPham chiTietSanPham){
        repo.add(chiTietSanPham);
    }
}
