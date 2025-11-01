package src.manager;

import java.util.Scanner;

import src.model.hoadon.HoaDon;

public class DanhSachHoaDon {
    private int n;
    private HoaDon[] hd;

    public DanhSachHoaDon() {
        n = 0;
        hd = new HoaDon[0];
    }

    // Nhập hóa đơn
    public void nhapHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hoa don: ");
        n = sc.nextInt();
        sc.nextLine();

        hd = new HoaDon[n];

        for (int i = 0; i < n; i++) {
            System.out.println("----- Thong tin don hang thu " + (i + 1) + " -----");

            hd[i] = new HoaDon();

            hd[i].nhap();
        }
    }
}
