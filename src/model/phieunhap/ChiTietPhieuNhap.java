package src.model.phieunhap;

import java.util.Scanner;
import src.model.sach.Sach;

public class ChiTietPhieuNhap {
    private PhieuNhap maPN;
    private Sach maSach;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(PhieuNhap maPN, Sach maSach, int soLuong, double donGia) {
        this.maPN = maPN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = donGia * soLuong;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        this.maPN = ctpn.maPN;
        this.maSach = ctpn.maSach;
        this.soLuong = ctpn.soLuong;
        this.donGia = ctpn.donGia;
        this.thanhTien = ctpn.donGia * ctpn.soLuong;
    }

    public PhieuNhap getPhieuNhap() {
        return maPN;
    }

    public void setPhieuNhap(PhieuNhap maPN) {
        this.maPN = maPN;
    }

    public Sach getSach() {
        return maSach;
    }

    public void setSach(Sach maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.thanhTien = this.donGia * soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
        this.thanhTien = donGia * this.soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void nhap(PhieuNhap pn, Sach sach) {
        Scanner sc = new Scanner(System.in);
        this.maPN = pn;
        this.maSach = sach;
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();

        this.thanhTien = this.donGia * this.soLuong;
    }

    public void xuat() {
        System.out.printf("| %-10s | %-10s | %-10s | %-15.2f | %-15.2f |\n", maPN.getMaPN(), maSach.getMaSach(),
                soLuong,
                donGia, thanhTien);
    }
}