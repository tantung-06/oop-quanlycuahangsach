package src.model.hoadon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import src.model.doitac.KhachHang;
import src.model.nhansu.NhanVien;

public class HoaDon {
    private String maHD;
    private LocalDate ngayLap;
    private String tongTien;
    private KhachHang maKH;
    private NhanVien maNV;

    public HoaDon() {
    }

    public HoaDon(String maHD, LocalDate ngayLap, String tongTien, KhachHang maKH, NhanVien maNV) {
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

        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ngay lap: ");
        String nl = sc.nextLine();
        ngayLap = LocalDate.parse(nl, f);
        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextLine();
    }

    public void xuat() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-15s %-15s %-15s", maHD, ngayLap.format(f), tongTien, maKH, maNV);
    }
}
