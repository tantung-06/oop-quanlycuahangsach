package src.manager;

import java.util.Scanner;

public class QuanLySach {
    Scanner sc = new Scanner(System.in);
    DanhSachSach dss = new DanhSachSach();
    DanhSachTacGia dstg = new DanhSachTacGia();
    DanhSachNhaXuatBan dsnxb = new DanhSachNhaXuatBan();

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH SACH ==========");
            System.out.println("1.  Xem danh sach sach");
            System.out.println("2.  Them sach");
            System.out.println("3.  Xoa sach theo ma");
            System.out.println("4.  Sua thong tin sach");
            System.out.println("5.  Tim kiem sach theo ma");
            System.out.println("6.  Tim kiem sach theo ten");
            System.out.println("7.  Thong ke tong so sach");
            System.out.println("8.  Thong ke so luong sach ton kho");
            System.out.println("9.  Doc file");
            System.out.println("10. Ghi file");
            System.out.println("0.  Thoat!");
            System.out.println("============================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    dss.xuatSach();
                    break;
                case 2:
                    dss.themSach();
                    break;
                case 3:
                    dss.xoaSachTheoMa();
                    break;
                case 4:
                    dss.suaSachTaiTruong();
                    break;
                case 5:
                    dss.timKiemSachTheoMa();
                    break;
                case 6:
                    dss.timKiemSachTheoTen();
                    break;
                case 7:
                    int[] tk = dss.thongKeTongSoSach();
                    System.out.println("So sach giao khoa: " + tk[0]);
                    System.out.println("So sach tham khao: " + tk[1]);
                    break;
                case 8:
                    int[] tk1 = dss.thongKeSoLuongSach();
                    System.out.println("Tong so luong sach ton kho: " + tk1[0]);
                    break;
                case 9:
                    dss.docFile();
                    break;
                case 10:
                    dss.ghiFile();
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