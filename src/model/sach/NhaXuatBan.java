package src.model.sach;

import java.util.Scanner;

public class NhaXuatBan {
    private String maNXB;
    private String ten;
    private String diaChi;

    public NhaXuatBan() {
    }

    public NhaXuatBan(String maNXB, String ten, String diaChi) {
        this.maNXB = maNXB;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public NhaXuatBan(NhaXuatBan nxb) {
        this.maNXB = nxb.maNXB;
        this.ten = nxb.ten;
        this.diaChi = nxb.diaChi;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nha xuat ban: ");
        maNXB = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-18s %-10s %-10s\n", maNXB, ten, diaChi);
    }
}
