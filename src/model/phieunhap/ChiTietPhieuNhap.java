package src.model.phieunhap;

import java.util.Scanner;

import src.model.hoadon.HoaDon;
import src.model.sach.Sach;

public class ChiTietPhieuNhap {
    private HoaDon maHD;
    private Sach maSach;
    private int soLuong;
    private int donGia;
    // thanhTien = donGia * soLuong

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(HoaDon maHD, Sach maSach, int soLuong, int donGia) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        this.maHD = ctpn.maHD;
        this.maSach = ctpn.maSach;
        this.soLuong = ctpn.soLuong;
        this.donGia = ctpn.donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap don gia: ");
        donGia = sc.nextInt();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
    }

    public int thanhTien() {
        return donGia * soLuong;
    }
}
