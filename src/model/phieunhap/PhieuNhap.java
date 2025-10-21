package src.model.phieunhap;

import java.util.Scanner;
import src.model.doitac.NhaCungCap;
import src.model.nhansu.NhanVien;

public class PhieuNhap {
    private String maPN;
    private String ngayLap;
    private NhaCungCap maNCC;
    private NhanVien maNV;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPN, String ngayLap, NhaCungCap maNCC, NhanVien maNV) {
        this.maPN = maPN;
        this.ngayLap = ngayLap;
        this.maNCC = maNCC;
        this.maNV = maNV;
    }

    public PhieuNhap(PhieuNhap pn) {
        this.maPN = pn.maPN;
        this.ngayLap = pn.ngayLap;
        this.maNCC = pn.maNCC;
        this.maNV = pn.maNV;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap: ");
        maPN = sc.nextLine();
        System.out.print("Nhap ngay lap: ");
        ngayLap = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-15s", maPN, ngayLap);
    }
}
