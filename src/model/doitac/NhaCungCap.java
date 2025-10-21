package src.model.doitac;

import java.util.Scanner;

public class NhaCungCap {
    private String maNCC;
    private String ten;
    private String soDienThoai;
    private String diaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String ten, String soDienThoai, String diaChi) {
        this.maNCC = maNCC;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public NhaCungCap(NhaCungCap ncc) {
        this.maNCC = ncc.maNCC;
        this.ten = ncc.ten;
        this.soDienThoai = ncc.soDienThoai;
        this.diaChi = ncc.diaChi;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nha cung cap: ");
        maNCC = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        soDienThoai = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-20s %-15s %-20s\n", maNCC, ten, soDienThoai, diaChi);
    }
}
