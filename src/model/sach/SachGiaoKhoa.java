package src.model.sach;

import java.util.Scanner;

import src.manager.DanhSachNhaXuatBan;
import src.manager.DanhSachTacGia;

public class SachGiaoKhoa extends Sach {
    private String lop;
    private String monHoc;

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(String maSach, String tenSach, String theLoai, int namXuatBan, int donGiaBan, int soLuong,
            TacGia maTG, NhaXuatBan maNXB, String lop, String monHoc) {
        super(maSach, tenSach, theLoai, namXuatBan, donGiaBan, soLuong, maTG, maNXB);
        this.lop = lop;
        this.monHoc = monHoc;
    }

    public SachGiaoKhoa(SachGiaoKhoa stk) {
        super((Sach) stk);
        this.lop = stk.lop;
        this.monHoc = stk.monHoc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    @Override
    public void nhap(DanhSachTacGia dstg, DanhSachNhaXuatBan dsnxb) {
        Scanner sc = new Scanner(System.in);
        super.nhap(dstg, dsnxb);
        System.out.print("Nhap lop: ");
        lop = sc.nextLine();
        System.out.print("Nhap mon hoc: ");
        monHoc = sc.nextLine();
    }

    @Override
    public void nhapKhongMa(DanhSachTacGia dstg, DanhSachNhaXuatBan dsnxb) {
        Scanner sc = new Scanner(System.in);
        super.nhapKhongMa(dstg, dsnxb);
        System.out.print("Nhap lop: ");
        lop = sc.nextLine();
        System.out.print("Nhap mon hoc: ");
        monHoc = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" %-5s | %-10s | %-12s | %-12s |\n", lop, monHoc, "-", "-");
    }

    @Override
    public String loai() {
        return "Giao khoa";
    }
}