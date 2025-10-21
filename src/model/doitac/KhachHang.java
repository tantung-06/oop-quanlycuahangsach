package src.model.doitac;

import java.util.Scanner;

public class KhachHang {
    private String maKH;
    private String ho;
    private String ten;
    private String soDienThoai;
    private String email;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKH, String ho, String ten, String soDienThoai, String email, String diaChi) {
        this.maKH = maKH;
        this.ho = ho;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public KhachHang(KhachHang kh) {
        this.maKH = kh.maKH;
        this.ho = kh.ho;
        this.ten = kh.ten;
        this.soDienThoai = kh.soDienThoai;
        this.email = kh.email;
        this.diaChi = kh.diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
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
        maKH = sc.nextLine();
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
        System.out.printf("%-15s %-10s %-10s %-15s %-30s %-15s\n", maKH, ho, ten, soDienThoai, email, soDienThoai);
    }
}
