package src.manager;

import java.util.Scanner;

public class QuanLyTacGia {
    Scanner sc = new Scanner(System.in);
    DanhSachTacGia dstg = new DanhSachTacGia();

    public void menu() {
        int lc;
        do {
            System.out.println("========== QUAN LY DANH SACH TAC GIA ==========");
            System.out.println("1. Xem danh sach tac gia");
            System.out.println("2. Them tac gia");
            System.out.println("3. Xoa tac gia theo ma");
            System.out.println("4. Sua thong tin tac gia");
            System.out.println("5. Tim kiem tac gia theo ma");
            System.out.println("6. Tim kiem tac gia theo ten");
            System.out.println("7. Thong ke tuoi");
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
                        dstg.xuatDS();
                        break;
                    case 2:
                        dstg.themTG();
                        break;
                    case 3:
                        dstg.xoaTG();
                        break;
                    case 4:
                        dstg.suaThongTin();
                        break;
                    case 5:
                        dstg.timKiemTGTheoMa();
                        break;
                    case 6:
                        dstg.timKiemTGTheoTen();
                        break;
                    case 7:
                        dstg.thongKeTuoi();
                        break;
                    case 8:
                        dstg.docFile();
                        break;
                    case 9:
                        dstg.ghiFile();
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
