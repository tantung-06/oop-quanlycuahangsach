package src.model.hoadon;

import java.util.Scanner;

import src.manager.DanhSachSach;
import src.model.sach.Sach;

public class ChiTietHoaDon {
    private String maHoaDon;
    private String maSach;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    private Sach sach;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHoaDon, String maSach, int soLuong, double donGia, double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = donGia * soLuong;
    }

    public ChiTietHoaDon(ChiTietHoaDon cthd) {
        this.maHoaDon = cthd.maHoaDon;
        this.maSach = cthd.maSach;
        this.soLuong = cthd.soLuong;
        this.donGia = cthd.donGia;
        this.thanhTien = cthd.soLuong * cthd.donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double donGia, int soLuong) {
        this.thanhTien = donGia * soLuong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don:");
        maHoaDon = sc.nextLine();
        System.out.print("Nhap ma sach:");
        maSach = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        thanhTien = donGia * soLuong;
    }

    public void xuat() {
        System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-15s |\n", maHoaDon, maSach,
                soLuong, donGia, getThanhTien());
    }
}