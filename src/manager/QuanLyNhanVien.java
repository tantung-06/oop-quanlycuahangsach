package src.manager;

import java.util.Scanner;

public class QuanLyNhanVien {
    Scanner sc = new Scanner(System.in);
    DanhSachNhanVien dsnv = new DanhSachNhanVien();

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH NHAN VIEN ==========");
            System.out.println("1. Xem danh sach nhan vien");
            System.out.println("2. Them nhan vien");
            System.out.println("3. Xoa nhan vien theo ma");
            System.out.println("4. Sua thong tin nhan vien");
            System.out.println("5. Tim kiem nhan vien theo ma");
            System.out.println("6. Tim kiem nhan vien theo ten");
            System.out.println("7. Thong ke luong");
            System.out.println("8. Doc file");
            System.out.println("9. Ghi file");
            System.out.println("0. Thoat!");
            System.out.println("=================================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            try {
                switch (lc) {
                    case 1:
                        dsnv.xuatDS();
                        break;
                    case 2:
                        dsnv.themNV();
                        break;
                    case 3:
                        dsnv.xoaNV();
                        break;
                    case 4:
                        dsnv.suaThongTin();
                        break;
                    case 5:
                        dsnv.timKiemNVTheoMa();
                        break;
                    case 6:
                        dsnv.timKiemNVTheoTen();
                        break;
                    case 7:
                        dsnv.thongKeLuong();
                        break;
                    case 8:
                        dsnv.docFile();
                        break;
                    case 9:
                        dsnv.ghiFile();
                        break;
                    case 0:
                        System.out.println("Thoat!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le, vui long nhap lai!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        } while (lc != 0);
    }
}