package src.model.nhansu;

import java.util.Scanner;

public class NhanVien {
    private String maNV;
    private String ho;
    private String ten;
    private String chucVu;
    private String luong;
    private String soDienThoai;

    public NhanVien() {
    }

    public NhanVien(String maNV, String ho, String ten, String chucVu, String luong, String soDienThoai) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.chucVu = chucVu;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
    }

    public NhanVien(NhanVien nv) {
        this.maNV = nv.maNV;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.chucVu = nv.chucVu;
        this.luong = nv.luong;
        this.soDienThoai = nv.soDienThoai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap chuc vu: ");
        chucVu = sc.nextLine();
        System.out.print("Nhap luong: ");
        luong = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        soDienThoai = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-10s %-10s %-15s %-15s %-15s\n", maNV, ho, ten, chucVu, luong, soDienThoai);
    }
}
