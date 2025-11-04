package src.manager;

import java.util.Scanner;

public class QuanLyNhaCungCap {
    Scanner sc = new Scanner(System.in);
    DanhSachNhaCungCap dsncc = new DanhSachNhaCungCap();

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH NHA CUNG CAP ==========");
            System.out.println("1. Xem danh sach nha cung cap");
            System.out.println("2. Them nha cung cap");
            System.out.println("3. Xoa nha cung cap theo ma");
            System.out.println("4. Sua thong tin nha cung cap");
            System.out.println("5. Tim kiem nha cung cap theo ma");
            System.out.println("6. Tim kiem nha cung cap theo ten");
            System.out.println("7. Thong ke tong so nha cung cap");
            System.out.println("8. Doc file");
            System.out.println("9. Ghi file");
            System.out.println("0. Thoat!");
            System.out.println("=================================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            String maKH;

            switch (lc) {
                case 1:
                    dsncc.XuatDs();
                    break;
                case 2:
                    dsncc.ThemNcc();
                    ;
                    break;
                case 3:
                    System.out.print("Nhap ma nha cung cap can xoa: ");
                    maKH = sc.nextLine();
                    dsncc.XoaNccTheoMa(maKH);
                    ;
                    break;
                case 4:
                    System.out.print("Nhap ma nha cung cap can sua: ");
                    maKH = sc.nextLine();
                    dsncc.SuaNcc(maKH);
                    ;
                    break;
                case 5:
                    System.out.print("Nhap ma nha cung cap can tim: ");
                    maKH = sc.nextLine();
                    dsncc.TimNccTheoMa(maKH);
                    break;
                case 6:
                    System.out.print("Nhap ten nha cung cap can tim: ");
                    maKH = sc.nextLine();
                    dsncc.TimNccTheoTen(maKH);
                    break;
                case 7:
                    dsncc.ThongKeNcc();
                    break;
                case 8:
                    dsncc.docfile();
                    ;
                    break;
                case 9:
                    dsncc.ghifile();
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