package com.example.ASS.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietSP")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NamBH")
    private Integer namBaoHanh;

    @Column(name = " MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
     private Integer soLuongTon;

    @Column(name = "GiaNhap")
     private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

    @ManyToOne
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    private NamSanXuat namSanXuat;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    private DongSanPham dongSanPham;

}
