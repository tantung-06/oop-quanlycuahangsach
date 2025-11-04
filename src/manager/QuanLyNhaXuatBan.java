package src.manager;

import java.util.Scanner;

public class QuanLyNhaXuatBan {
    Scanner sc = new Scanner(System.in);
    DanhSachNhaXuatBan dsnxb = new DanhSachNhaXuatBan();

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH NHA XUAT BAN ==========");
            System.out.println("1. Xem danh sach nha xuat ban");
            System.out.println("2. Them nha xuat ban");
            System.out.println("3. Xoa nha xuat ban theo ma");
            System.out.println("4. Sua thong tin nha xuat ban");
            System.out.println("5. Tim kiem nha xuat ban theo ma");
            System.out.println("6. Tim kiem nha xuat ban theo ten");
            System.out.println("7. Thong ke thanh pho");
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
                        dsnxb.xuatDS();
                        break;
                    case 2:
                        dsnxb.themNXB();
                        break;
                    case 3:
                        dsnxb.xoaNXB();
                        break;
                    case 4:
                        dsnxb.suaThongTin();
                        break;
                    case 5:
                        dsnxb.timKiemNXBTheoMa();
                        break;
                    case 6:
                        dsnxb.timKiemNXBTheoTen();
                        break;
                    case 7:
                        dsnxb.thongKeThanhPho();
                        break;
                    case 8:
                        dsnxb.docFile();
                        break;
                    case 9:
                        dsnxb.ghiFile();
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