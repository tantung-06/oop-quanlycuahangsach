package src.model.phieunhap;

import java.util.Scanner;
import src.model.sach.Sach;

public class ChiTietPhieuNhap {
    private PhieuNhap maPN;
    private Sach maSach;
    private int soLuong;
    private double donGia;
    // thanhTien = donGia * soLuong

    public ChiTietPhieuNhap() {
        maPN = new PhieuNhap();
        maSach = null;
    }

    public ChiTietPhieuNhap(PhieuNhap maPN, Sach maSach, int soLuong, double donGia) {
        this.maPN = maPN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn) {
        this.maPN = ctpn.maPN;
        this.maSach = ctpn.maSach;
        this.soLuong = ctpn.soLuong;
        this.donGia = ctpn.donGia;
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
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);

        maPN = new PhieuNhap();
        System.out.print("Nhap ma phieu nhap: ");
        maPN.setMaPN(sc.nextLine());

        System.out.print("Nhap ma sach: ");
        maSach.setMaSach(sc.nextLine());

        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
    }

    public void xuat() {
        System.out.printf("MaPN: %s | MaSach: %s | SoLuong: %d | DonGia: %.2f | ThanhTien: %.2f\n",
                maPN.getMaPN(), maSach.getMaSach(), soLuong, donGia, thanhTien());
    }

    public double thanhTien() {
        return donGia * soLuong;
    }
}
