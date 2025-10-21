package src.model.phieunhap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import src.model.doitac.NhaCungCap;
import src.model.nhansu.NhanVien;

public class PhieuNhap {
    private String maPN;
    private LocalDate ngayLap;
    private String tongTien;
    private NhaCungCap maNCC;
    private NhanVien maNV;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPN, LocalDate ngayLap, String tongTien, NhaCungCap maNCC, NhanVien maNV) {
        this.maPN = maPN;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maNCC = maNCC;
        this.maNV = maNV;
    }

    public PhieuNhap(PhieuNhap pn) {
        this.maPN = pn.maPN;
        this.ngayLap = pn.ngayLap;
        this.tongTien = pn.tongTien;
        this.maNCC = pn.maNCC;
        this.maNV = pn.maNV;
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

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhap ma phieu nhap: ");
        maPN = sc.nextLine();
        System.out.print("Nhap ngay lap: ");
        String nl = sc.nextLine();
        ngayLap = LocalDate.parse(nl, f);
        System.out.print("Nhap tong tien: ");
    }

    public void xuat() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-15s %-15s", maPN, ngayLap.format(f), tongTien, maNCC, maNV);
    }
}
