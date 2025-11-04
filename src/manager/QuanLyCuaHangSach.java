package src.manager;

import java.util.Scanner;

public class QuanLyCuaHangSach {
    Scanner sc = new Scanner(System.in);
    QuanLySach qls = new QuanLySach();
    QuanLyKhachHang qlkh = new QuanLyKhachHang();
    QuanLyNhanVien qlnv = new QuanLyNhanVien();
    QuanLyNhaCungCap qlncc = new QuanLyNhaCungCap();
    QuanLyTacGia qltg = new QuanLyTacGia();
    QuanLyNhaXuatBan qlnxb = new QuanLyNhaXuatBan();
    QuanLyHoaDon qlhd = new QuanLyHoaDon();
    QuanLyPhieuNhap qlpn = new QuanLyPhieuNhap();

    public void menuChinh() {
        int lc;
        do {
            System.out.println("========== HE THONG QUAN LY CUA HANG SACH ==========");
            System.out.println("1. Quan ly sach");
            System.out.println("2. Quan ly khach hang");
            System.out.println("3. Quan ly nhan vien");
            System.out.println("4. Quan ly nha cung cap");
            System.out.println("5. Quan ly tac gia");
            System.out.println("6. Quan ly nha xuat ban");
            System.out.println("7. Quan ly hoa don - chi tiet hoa don");
            System.out.println("8. Quan ly phieu nhap - chi tiet phieu nhap");
            System.out.println("0. Thoat!");
            System.out.println("====================================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    qls.menu();
                    break;
                case 2:
                    qlkh.menu();
                    break;
                case 3:
                    qlnv.menu();
                    break;
                case 4:
                    qlncc.menu();
                    break;
                case 5:
                    qltg.menu();
                    break;
                case 6:
                    qlnxb.menu();
                    break;
                case 7:
                    qlhd.menu();
                    break;
                case 8:
                    qlpn.menu();
                    break;
                case 0:
                    System.out.println("Thoat!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai");
                    break;
            }
        } while (lc != 0);
    }
}