package src.model.hoadon;

import java.util.Scanner;

import src.model.doitac.KhachHang;
import src.model.nhansu.NhanVien;

public class HoaDon {
    private String maHD;
    private String ngayLap;
    private String tongTien;
    private KhachHang maKH;
    private NhanVien maNV;

    public HoaDon() {
    }

    public HoaDon(String maHD, String ngayLap, String tongTien, KhachHang maKH, NhanVien maNV) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maKH = maKH;
        this.maNV = maNV;
    }

    public HoaDon(HoaDon hd) {
        this.maHD = hd.maHD;
        this.ngayLap = hd.ngayLap;
        this.tongTien = hd.tongTien;
        this.maKH = hd.maKH;
        this.maNV = hd.maNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
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
        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ngay lap: ");
        ngayLap = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-15s %-15s %-15s", maHD, ngayLap, tongTien);
    }
}
