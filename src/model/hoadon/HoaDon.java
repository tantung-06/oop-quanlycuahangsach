package src.model.hoadon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import src.manager.DanhSachChiTietHoaDon;
import src.model.doitac.KhachHang;
import src.model.nhansu.NhanVien;

public class HoaDon {
    private String maHoaDon;
    private LocalDate ngayLap;
    private double tongTien;
    private String maKhachHang;
    private String maNV;
    private double tienKhachHangDua;
    private double tienThua;
    private DanhSachChiTietHoaDon cthd;
    DanhSachChiTietHoaDon dscthd = new DanhSachChiTietHoaDon();

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, LocalDate ngayLap, double tongTien, String maKhachHang, String maNV,
            double tienKhachHangDua, double tienThua) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maKhachHang = maKhachHang;
        this.maNV = maNV;
        this.tienKhachHangDua = tienKhachHangDua;
        this.tienThua = tienThua;
    }

    public HoaDon(HoaDon hd) {
        this.maHoaDon = hd.maHoaDon;
        this.ngayLap = hd.ngayLap;
        this.tongTien = hd.tongTien;
        this.maKhachHang = hd.maKhachHang;
        this.maNV = hd.maNV;
        this.tienKhachHangDua = hd.tienKhachHangDua;
        this.tienThua = hd.tienThua;
    }

    public HoaDon(DanhSachChiTietHoaDon cthd) {
        this.cthd = cthd;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNV;
    }

    public void setMaNhanVien(String maNV) {
        this.maNV = maNV;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTienKhachDua() {
        return tienKhachHangDua;
    }

    public void setTienKhachDua(double tienKhachHangDua) {
        this.tienKhachHangDua = tienKhachHangDua;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Nhap ma hoa don: ");
        maHoaDon = sc.nextLine();
        System.out.print("Nhap ngay lap: ");
        String nl = sc.nextLine();
        ngayLap = LocalDate.parse(nl, f);
        System.out.print("Nhap ma nhan vien:");
        maNV = sc.nextLine();
        System.out.print("Nhap tien khach dua:");
        tienKhachHangDua = sc.nextDouble();
        tienThua = tienKhachHangDua - dscthd.tongTien(maHoaDon);
        tongTien = dscthd.tongTien(maHoaDon);
    }

    public void xuat() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("| %-12s | %-12s | %-15s | %-15s | %-15s | %-20s | %-15s |\n", maHoaDon,
                ngayLap.format(f), tongTien, maKhachHang,
                maNV, tienKhachHangDua, tienThua);
    }
}