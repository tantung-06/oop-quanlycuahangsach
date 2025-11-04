package src.model.sach;

import java.util.Scanner;

import src.manager.DanhSachNhaXuatBan;
import src.manager.DanhSachTacGia;

public class Sach {
    protected String maSach;
    protected String tenSach;
    protected String theLoai;
    protected int namXuatBan;
    protected int donGia;
    protected int soLuong;
    protected TacGia maTG;
    protected NhaXuatBan maNXB;

    public Sach() {
        maTG = new TacGia();
        maNXB = new NhaXuatBan();
    }

    public Sach(String maSach, String tenSach, String theLoai, int namXuatBan, int donGia, int soLuong, TacGia maTG,
            NhaXuatBan maNXB) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.maTG = maTG;
        this.maNXB = maNXB;
    }

    public Sach(Sach s) {
        this.maSach = s.maSach;
        this.tenSach = s.tenSach;
        this.theLoai = s.theLoai;
        this.namXuatBan = s.namXuatBan;
        this.donGia = s.donGia;
        this.soLuong = s.soLuong;
        this.maTG = s.maTG;
        this.maNXB = s.maNXB;
    }

    // thắng thêm
    public Sach(String maSach) {
        this.maSach = maSach;
    }

    // @Override
    // public String toString() {
    // return maSach;
    // }
    //

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public TacGia getTacGia() {
        return maTG;
    }

    public void setTacGia(TacGia maTG) {
        this.maTG = maTG;
    }

    public NhaXuatBan getNhaXuatBan() {
        return maNXB;
    }

    public void setNhaXuatBan(NhaXuatBan maNXB) {
        this.maNXB = maNXB;
    }

    public void nhap(DanhSachTacGia dstg, DanhSachNhaXuatBan dsnxb) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        nhapKhongMa(dstg, dsnxb);
    }

    public void nhapKhongMa(DanhSachTacGia dstg, DanhSachNhaXuatBan dsnxb) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap the loai: ");
        theLoai = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = sc.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = sc.nextInt();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();

        TacGia tg = null;
        do {
            System.out.print("Nhap ma tac gia: ");
            String ma = sc.nextLine();
            tg = dstg.layTacGia(ma);
            if (tg == null)
                System.out.println("Ma tac gia khong ton tai, vui long nhap lai!");
        } while (tg == null);
        this.maTG = tg;

        NhaXuatBan nxb = null;
        do {
            System.out.print("Nhap ma nha xuat ban: ");
            String ma = sc.nextLine();
            nxb = dsnxb.layNXB(ma);
            if (nxb == null)
                System.out.println("Ma nha xuat ban khong ton tai, vui long nhap lai!");
        } while (nxb == null);
        this.maNXB = nxb;
    }

    public void xuat() {
        System.out.printf("| %-10s | %-20s | %-10s | %-12s | %-14s | %-10s | %-10s | %-15s |", maSach, tenSach, theLoai,
                namXuatBan, donGia, soLuong, maTG.getMaTG(), maNXB.getMaNXB());
    }

    public String loai() {
        return "Sach";
    }
}