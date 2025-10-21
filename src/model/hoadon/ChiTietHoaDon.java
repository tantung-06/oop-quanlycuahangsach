package src.model.hoadon;

import java.util.Scanner;
import src.model.sach.Sach;

public class ChiTietHoaDon {
    private HoaDon maHD;
    private Sach maSach;
    private int soLuong;
    private int donGia;
    // thanhTien = donGia * soLuong

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(HoaDon maHD, Sach maSach, int soLuong, int donGia) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietHoaDon(ChiTietHoaDon cthd) {
        this.maHD = cthd.maHD;
        this.maSach = cthd.maSach;
        this.soLuong = cthd.soLuong;
        this.donGia = cthd.donGia;
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
