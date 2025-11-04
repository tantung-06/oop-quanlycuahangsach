package src.model.phieunhap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import src.manager.DanhSachChiTietPhieuNhap;
import src.manager.DanhSachNhaCungCap;
import src.manager.DanhSachNhanVien;
import src.model.doitac.NhaCungCap;
import src.model.nhansu.NhanVien;

public class PhieuNhap {
    private String maPN;
    private LocalDate ngayLap;
    private double tongTien; // tong cac thanh tien trong ct hoa don
    private NhaCungCap maNCC;
    private NhanVien maNV;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPN, LocalDate ngayLap, double tongTien, NhaCungCap maNCC, NhanVien maNV) {
        this.maPN = maPN;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maNCC = maNCC;
        this.maNV = maNV;
    }

    public PhieuNhap(String maPN) {
        this.maPN = maPN;
    }

    public PhieuNhap(PhieuNhap pn) {
        this.maPN = pn.maPN;
        this.ngayLap = pn.ngayLap;
        this.tongTien = pn.tongTien;
        this.maNCC = pn.maNCC;
        this.maNV = pn.maNV;
    }

    public void setMaNCC(NhaCungCap maNCC) {
        this.maNCC = maNCC;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public NhaCungCap getNhaCungCap() {
        return maNCC;
    }

    public void setNhaCungCap(NhaCungCap maNCC) {
        this.maNCC = maNCC;
    }

    public NhanVien getNhanVien() {
        return maNV;
    }

    public void setNhanVien(NhanVien maNV) {
        this.maNV = maNV;
    }

    public void nhap(DanhSachNhaCungCap dsncc, DanhSachNhanVien dsnv) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhap ma phieu nhap: ");
        maPN = sc.nextLine();
        System.out.print("Nhap ngay lap: ");
        String nl = sc.nextLine();
        ngayLap = LocalDate.parse(nl, f);

        NhaCungCap ncc;
        do {
            System.out.print("Nhap ma nha cung cap: ");
            String ma = sc.nextLine();
            ncc = dsncc.layNCC(ma);
            if (ncc == null) {
                System.out.println("Ma nha cung cap khong ton tai, vui long nhap lai!");
            }
        } while (ncc == null);
        this.maNCC = ncc;

        NhanVien nv;
        do {
            System.out.print("Nhap ma nhan vien: ");
            String ma = sc.nextLine();
            nv = dsnv.layNV(ma);
            if (nv == null) {
                System.out.println("Ma nhan vien khong ton tai, vui long nhap lai!");
            }
        } while (nv == null);
        this.maNV = nv;
    }

    public void CapNhatTongTien(DanhSachChiTietPhieuNhap dsct) {
        this.tongTien = dsct.tinhTongTienTheoMaPN(this.maPN);
    }

    public void xuat() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("| %-20s | %-15s | %-15.2f | %-20s | %-15s |\n", maPN, ngayLap.format(f), tongTien,
                maNCC.getMaNCC(), maNV.getMaNV());
    }
}
