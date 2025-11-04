package src.manager;

import java.util.Scanner;

public class QuanLyKhachHang {
    Scanner sc = new Scanner(System.in);
    DanhSachKhachHang dskh = new DanhSachKhachHang();

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH KHACH HANG ==========");
            System.out.println("1. Xem danh sach khach hang");
            System.out.println("2. Them khach hang");
            System.out.println("3. Xoa khach hang theo ma");
            System.out.println("4. Sua thong tin khach hang");
            System.out.println("5. Tim kiem khach hang theo ma");
            System.out.println("6. Tim kiem khach hang theo ten");
            System.out.println("7. Thong ke so luong khach hang");
            System.out.println("8. Doc file");
            System.out.println("9. Ghi file");
            System.out.println("0. Thoat!");
            System.out.println("=================================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    dskh.hienThithongTinKhachHang();
                    break;
                case 2:
                    dskh.themKhachHang();
                    break;
                case 3:
                    System.out.print("Nhap ma khach hang can xoa: ");
                    dskh.xoaKhachHang(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap ma khach hang can sua: ");
                    dskh.suaThongTinKhachHang(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap ma khach hang can tim: ");
                    dskh.TimKHTheoMa(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhap ten khach hang can tim: ");
                    dskh.TimKiemTheoTen(sc.nextLine());
                    break;
                case 7:
                    dskh.thongKeSoLuongKH();
                    break;
                case 8:
                    dskh.docFile();
                    break;
                case 9:
                    dskh.ghiFile();
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