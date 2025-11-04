package src.manager;

import java.util.Scanner;

public class QuanLyPhieuNhap {
    Scanner sc = new Scanner(System.in);
    DanhSachPhieuNhap dspn = new DanhSachPhieuNhap();
    DanhSachChiTietPhieuNhap dsctpn = new DanhSachChiTietPhieuNhap();
    DanhSachSach dssach = new DanhSachSach();

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH PHIEU NHAP ==========");
            System.out.println("1. Xem danh sach phieu nhap");
            System.out.println("2. Them phieu nhap");
            System.out.println("3. Xoa phieu nhap theo ma");
            System.out.println("4. Sua thong tin phieu nhap");
            System.out.println("5. Tim kiem phieu nhap theo ma");
            System.out.println("6. Thong ke phieu nhap");
            System.out.println("7. Chi tiet phieu nhap");
            System.out.println("8. Doc file");
            System.out.println("9. Ghi file");
            System.out.println("0. Thoat!");
            System.out.println("=================================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    dspn.Xuatds();
                    break;
                case 2:
                    dspn.ThemPN();
                    break;
                case 3:
                    System.out.print("Nhap ma phieu nhap can xoa: ");
                    String maPN = sc.nextLine();
                    dspn.XoaPNTheoMaPN(maPN);
                    break;
                case 4:
                    dspn.suaPhieuNhap();
                    break;
                case 5:
                    menuTimKiemPhieuNhap();
                    break;
                case 6:
                    menuThongKePhieuNhap();
                    break;
                case 7:
                    menuChiTietPhieuNhap();
                    break;
                case 8:
                    docFile();
                    break;
                case 9:
                    ghiFile();
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

    private void menuTimKiemPhieuNhap() {
        int lc;
        do {
            System.out.println("===== TIM KIEM PHIEU NHAP =====");
            System.out.println("1. Tim kiem theo ma phieu nhap");
            System.out.println("2. Tim kiem theo ma nha cung cap");
            System.out.println("3. Tim kiem theo ma nhan vien");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    System.out.print("Nhap ma phieu nhap: ");
                    String maPN = sc.nextLine();
                    dspn.TimKiemPnTheoMaPN(maPN);
                    break;
                case 2:
                    System.out.print("Nhap ma nha cung cap: ");
                    String maNCC = sc.nextLine();
                    dspn.TimKiemPnTheoMaNCC(maNCC);
                    break;
                case 3:
                    System.out.print("Nhap ma nhan vien: ");
                    String maNV = sc.nextLine();
                    dspn.TimKiemPnTheoMaNV(maNV);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (lc != 0);
    }

    private void menuThongKePhieuNhap() {
        int lc;
        do {
            System.out.println("===== THONG KE PHIEU NHAP =====");
            System.out.println("1. Thong ke tong doanh thu theo quy");
            System.out.println("2. Thong ke theo nha cung cap");
            System.out.println("3. Thong ke so phieu nhap theo ma NCC");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    dspn.ThongKeTongDoanhThuTheoQuy();
                    break;
                case 2:
                    dspn.ThongKeTheoNCC();
                    break;
                case 3:
                    System.out.print("Nhap ma nha cung cap: ");
                    String maNCC = sc.nextLine();
                    dspn.ThongKePnTheoNCC(maNCC);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (lc != 0);
    }

    private void menuChiTietPhieuNhap() {
        int lc;
        do {
            System.out.println("===== QUAN LY CHI TIET PHIEU NHAP =====");
            System.out.println("1. Xem danh sach chi tiet phieu nhap");
            System.out.println("2. Them chi tiet phieu nhap");
            System.out.println("3. Xoa chi tiet phieu nhap");
            System.out.println("4. Sua chi tiet phieu nhap");
            System.out.println("5. Tim kiem chi tiet phieu nhap");
            System.out.println("6. Thong ke chi tiet phieu nhap");
            System.out.println("0. Quay lai");
            System.out.println("=======================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    dsctpn.xuatDsCtPn();
                    break;
                case 2:
                    dsctpn.ThemChiTietPn(dspn, dssach);
                    capNhatTongTienPhieuNhap();
                    break;
                case 3:
                    xoaChiTietPhieuNhap();
                    break;
                case 4:
                    suaChiTietPhieuNhap();
                    break;
                case 5:
                    menuTimKiemChiTietPhieuNhap();
                    break;
                case 6:
                    menuThongKeChiTietPhieuNhap();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (lc != 0);
    }

    private void xoaChiTietPhieuNhap() {
        System.out.print("Nhap ma phieu nhap: ");
        String maPN = sc.nextLine();
        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();
        dsctpn.XoaDsCtPn(maPN, maSach);
        capNhatTongTienPhieuNhap();
    }

    private void suaChiTietPhieuNhap() {
        System.out.print("Nhap ma phieu nhap: ");
        String maPN = sc.nextLine();
        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();
        dsctpn.SuaCtPn(maPN, maSach, dspn, dssach);
        capNhatTongTienPhieuNhap();
    }

    private void capNhatTongTienPhieuNhap() {
        System.out.print("Nhap ma phieu nhap can cap nhat tong tien: ");
        String maPN = sc.nextLine();
        var pn = dspn.layPhieuNhap(maPN);
        if (pn != null) {
            pn.CapNhatTongTien(dsctpn);
            System.out.println("Cap nhat tong tien thanh cong! Tong tien moi: " + pn.getTongTien());
        } else {
            System.out.println("Khong tim thay phieu nhap!");
        }
    }

    private void menuTimKiemChiTietPhieuNhap() {
        int lc;
        do {
            System.out.println("===== TIM KIEM CHI TIET PHIEU NHAP =====");
            System.out.println("1. Tim kiem theo ma phieu nhap va ma sach");
            System.out.println("2. Tim kiem theo so luong");
            System.out.println("3. Tim kiem theo don gia");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    System.out.print("Nhap ma phieu nhap: ");
                    String maPN = sc.nextLine();
                    System.out.print("Nhap ma sach: ");
                    String maSach = sc.nextLine();
                    dsctpn.TimKiemCtPnTheoMa(maPN, maSach);
                    break;
                case 2:
                    System.out.print("Nhap so luong: ");
                    int soLuong = sc.nextInt();
                    sc.nextLine();
                    dsctpn.TimKiemCtPnTheoSL(soLuong);
                    break;
                case 3:
                    System.out.print("Nhap don gia: ");
                    double donGia = sc.nextDouble();
                    sc.nextLine();
                    dsctpn.TimKiemCtPnTheoDonGia(donGia);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (lc != 0);
    }

    private void menuThongKeChiTietPhieuNhap() {
        int lc;
        do {
            System.out.println("===== THONG KE CHI TIET PHIEU NHAP =====");
            System.out.println("1. Thong ke tong so luong sach da nhap");
            System.out.println("2. Thong ke theo ma sach");
            System.out.println("3. Thong ke theo ma phieu nhap");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    int tongSL = dsctpn.ThongKeSLSachDaNhap();
                    break;
                case 2:
                    System.out.print("Nhap ma sach: ");
                    String maSach = sc.nextLine();
                    dsctpn.ThongKeTheoMaSach(maSach);
                    break;
                case 3:
                    System.out.print("Nhap ma phieu nhap: ");
                    String maPN = sc.nextLine();
                    dsctpn.ThongKeTheoMaPN(maPN);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (lc != 0);
    }

    private void docFile() {
        dspn.docfile();
        dsctpn.docfile();
    }

    private void ghiFile() {
        dspn.ghiFile();
        dsctpn.ghifile();
    }
}