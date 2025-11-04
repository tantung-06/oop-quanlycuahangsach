package src.model.doitac;

import java.util.Scanner;

import src.manager.DanhSachKhachHang;

public class KhachHang {
    private String maKhachHang;
    private String ho;
    private String ten;
    private String soDienThoai;
    private String email;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String ho, String ten, String soDienThoai, String email, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.ho = ho;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public KhachHang(KhachHang kh) {
        this.maKhachHang = kh.maKhachHang;
        this.ho = kh.ho;
        this.ten = kh.ten;
        this.soDienThoai = kh.soDienThoai;
        this.email = kh.email;
        this.diaChi = kh.diaChi;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang: ");
        maKhachHang = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        soDienThoai = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-25s | %-15s |\n", maKhachHang, ho, ten, soDienThoai,
                email, diaChi);
    }
}