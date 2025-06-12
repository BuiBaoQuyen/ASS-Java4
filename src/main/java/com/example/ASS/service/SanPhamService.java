package com.example.ASS.service;

import com.example.ASS.entity.SanPham;
import com.example.ASS.repository.SanPhamRepo;

import java.util.List;

public class SanPhamService {
    private SanPhamRepo sanPhamRepo = new SanPhamRepo();

    public List<SanPham> getAll(){
        return sanPhamRepo.getAll();
    }
    public SanPham getOne(Long id){
        return sanPhamRepo.getOne(id);
    }
}
