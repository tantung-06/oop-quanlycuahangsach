package src.model.sach;

import java.util.Scanner;

public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;
    private String diaChi;

    public NhaXuatBan() {
    }

    public NhaXuatBan(String maNXB, String tenNXB, String diaChi) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
    }

    public NhaXuatBan(NhaXuatBan nxb) {
        this.maNXB = nxb.maNXB;
        this.tenNXB = nxb.tenNXB;
        this.diaChi = nxb.tenNXB;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
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
        System.out.print("Nhap ten nha xuat ban: ");
        tenNXB = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diaChi = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("| %-20s | %-20s | %-20s |\n", maNXB, tenNXB, diaChi);
    }
}
