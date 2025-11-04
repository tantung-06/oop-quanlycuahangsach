package src.manager;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class QuanLyHoaDon {
    Scanner sc = new Scanner(System.in);
    DanhSachSach dssach = new DanhSachSach();
    DanhSachChiTietHoaDon dscthd = new DanhSachChiTietHoaDon(dssach);
    DanhSachHoaDon dshd = new DanhSachHoaDon(dssach, dscthd);

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH HOA DON ==========");
            System.out.println("1. Xem danh sach hoa don");
            System.out.println("2. Them hoa don");
            System.out.println("3. Xoa hoa don theo ma");
            System.out.println("4. Sua thong tin hoa don");
            System.out.println("5. Tim kiem hoa don theo ma hoa don");
            System.out.println("6. Tim kiem hoa don theo ma nhan vien");
            System.out.println("7. Tim kiem hoa don theo ma khach hang");
            System.out.println("8. Tong doanh thu theo ngay");
            System.out.println("9. Tong doanh thu theo thang");
            System.out.println("10. Tong doanh thu theo nam");
            System.out.println("11. Hien thi hoa don theo ngay");
            System.out.println("12. Hien thi hoa don theo thang");
            System.out.println("13. Hien thi hoa don theo nam");
            System.out.println("14.Doc file");
            System.out.println("15.Ghi file");
            System.out.println("0.Thoat!");
            System.out.println("=================================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();
            switch (lc) {
                case 1:
                    dshd.hienThiHoaDon();
                    break;
                case 2:
                    dscthd.nhapHoaDon();
                    dshd.themHoaDon();
                    break;
                case 3:
                    System.out.print("Nhap ma hoa don ma ban muon xoa:");
                    String maHoaDon = sc.nextLine();
                    dshd.xoaHoaDon(maHoaDon);
                    dscthd.XoaChiTietHoaDonTheoMa(maHoaDon);
                    break;
                case 4:
                    System.out.print("Nhap ma hoa don ma ban muon sua:");
                    maHoaDon = sc.nextLine();
                    dshd.suaThongTinHoaDon(maHoaDon);
                    System.out.println("Ban co muon sua luon chi tiet hoa don khong(y/n)?");
                    String trl = sc.nextLine();
                    while (true) {
                        if (trl.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            dscthd.suaThongTinChiTietHoaDon(maHoaDon);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhap ma hoa don ma ban muon tim:");
                    maHoaDon = sc.nextLine();
                    dshd.hienThiHoaDonTheoMaHD(maHoaDon);
                    break;
                case 6:
                    System.out.print("Nhap ma nhan vien:");
                    String maNhanVien = sc.nextLine();
                    dshd.hienThiHoaDonTheoMaNV(maNhanVien);
                    break;
                case 7:
                    System.out.print("Nhap ma khach hang:");
                    String maKhachHang = sc.nextLine();
                    dshd.hienThiHoaDonTheoMaKH(maKhachHang);
                    break;
                case 8:
                    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    System.out.print("Nhap ngay ma ban muon kiem tra tong so tien(dd/MM/yyyy):");
                    String ngayStr = sc.nextLine();
                    LocalDate ngayCanThongKe = LocalDate.parse(ngayStr, f);
                    int ngay = ngayCanThongKe.getDayOfMonth();
                    int thang = ngayCanThongKe.getMonthValue();
                    int nam = ngayCanThongKe.getYear();
                    System.out.println(
                            "Tong so tien thu cua ngay " + ngayStr + ":" + dshd.tongDoanhThuNgay(ngay, thang, nam));
                    break;
                case 9:
                    f = DateTimeFormatter.ofPattern("MM/yyyy");
                    System.out.print("Nhap thang ma ban muon kiem tra tong so tien(MM/yyyy):");
                    ngayStr = sc.nextLine();
                    YearMonth thangCanThongKe = YearMonth.parse(ngayStr, f);
                    thang = thangCanThongKe.getMonthValue();
                    nam = thangCanThongKe.getYear();
                    System.out.println(
                            "Tong so tien thu cua thang " + ngayStr + ":" + dshd.tongDanhThuTheoThang(thang, nam));
                    break;
                case 10:
                    f = DateTimeFormatter.ofPattern("yyyy");
                    System.out.print("Nhap nam ma ban muon kiem tra doanh thu(yyyy):");
                    nam = sc.nextInt();
                    System.out.println("Tong so tien thu cua nam " + nam + ":" + dshd.tongDoanhThuTheoNam(nam));
                    break;
                case 11:
                    f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    System.out.print("Nhap ngay ma ban muon hien thi hoa don(dd/MM/yyyy):");
                    ngayStr = sc.nextLine();
                    ngayCanThongKe = LocalDate.parse(ngayStr, f);
                    ngay = ngayCanThongKe.getDayOfMonth();
                    thang = ngayCanThongKe.getMonthValue();
                    nam = ngayCanThongKe.getYear();
                    dshd.hienThiHoaDonTheoNgay(ngay, thang, nam);
                    break;
                case 12:
                    f = DateTimeFormatter.ofPattern("MM/yyyy");
                    System.out.print("Nhap thang ma ban muon hien thi hoa don(MM/yyyy):");
                    ngayStr = sc.nextLine();
                    thangCanThongKe = YearMonth.parse(ngayStr, f);
                    thang = thangCanThongKe.getMonthValue();
                    nam = thangCanThongKe.getYear();
                    dshd.hienThiHoaDonTheoThang(thang, nam);
                    break;
                case 13:
                    System.out.print("Nhap nam ma ban muon hien thi hoa don(yyyy):");
                    nam = sc.nextInt();
                    dshd.hienThiHoaDonTheoNam(nam);
                    break;
                case 14:
                    dscthd.docFile();
                    dshd.docFile();
                    dssach.docFile();
                    break;
                case 15:
                    dscthd.ghiFile();
                    dshd.ghiFile();
                    dssach.ghiFile();
                    break;
                case 0:
                    System.out.println("Thoat!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        } while (lc != 0);
    }
}