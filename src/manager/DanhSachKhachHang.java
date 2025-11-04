package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import src.model.doitac.KhachHang;

public class DanhSachKhachHang {
    private int soLuongKhachHang;
    private KhachHang[] dskh;

    KhachHang kh = new KhachHang();

    public DanhSachKhachHang() {
        soLuongKhachHang = 0;
        dskh = new KhachHang[0];
    }

    public DanhSachKhachHang(KhachHang[] dskh) {
        this.dskh = dskh;
    }

    public DanhSachKhachHang(DanhSachKhachHang ds) {
        this.dskh = ds.dskh;
    }

    public KhachHang[] getDSKH() {
        return dskh;
    }

    public void setDSKH(KhachHang[] dskh) {
        this.dskh = dskh;
    }

    public void themKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong khach hang muon them:");
        int n = sc.nextInt();
        dskh = Arrays.copyOf(dskh, dskh.length + n);
        for (int i = 0; i < n; i++) {
            dskh[soLuongKhachHang] = new KhachHang();
            dskh[soLuongKhachHang].nhap();
            sc.nextLine();
            while (kiemTraMaKhachHang(dskh[soLuongKhachHang].getMaKhachHang())) {
                System.out.print("Ma khach hang bi trung! Vui long nhap lai ma:");
                String maNhapLai = sc.nextLine();
                dskh[soLuongKhachHang].setMaKhachHang(maNhapLai);
            }
            soLuongKhachHang++;
        }
    }

    public void xoaKhachHang(String maKhachHang) {
        int vitri = -1;
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (dskh[i].getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
                vitri = i;
                break;
            }
        }
        if (vitri != -1) {
            for (int j = vitri; j < soLuongKhachHang - 1; j++) {
                dskh[j] = dskh[j + 1];
            }
            soLuongKhachHang--;
            dskh = Arrays.copyOf(dskh, soLuongKhachHang);
            System.out.println("Da xoa khach hang nay khoi danh sach!");
        } else {
            System.out.println("Khong co khach hang nay trong danh sach!");
        }
    }

    public void hienThithongTinKhachHang() {
        if (soLuongKhachHang == 0) {
            System.out.println("Danh sach trong!");
        } else {
            System.out.println("========== DANH SACH KHACH HANG ==========");
            System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-25s | %-15s |\n", "Ma khach hang", "Ho", "Ten",
                    "So dien thoai", "Email", "Dia chi");
            for (int i = 0; i < soLuongKhachHang; i++) {
                dskh[i].xuat();
            }
        }
    }

    public void suaThongTinKhachHang(String maKhachHang) {
        Scanner sc = new Scanner(System.in);
        int luachon = 1;
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (dskh[i].getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
                while (luachon > 0) {
                    System.out.println("""
                            ===== SUA THONG TIN KHACH HANG
                            1. Sua ho
                            2. Sua ten
                            3. Sua dia chi
                            4. Sua so dien thoai
                            5. Sua email
                            0. Thoat!
                            """);
                    System.out.print("Nhap lua chon: ");
                    luachon = sc.nextInt();
                    sc.nextLine();
                    switch (luachon) {
                        case 1:
                            System.out.print("Nhap ho khach hang:");
                            String ho = sc.nextLine();
                            dskh[i].setHo(ho);
                            break;
                        case 2:
                            System.out.print("Nhap ten khach hang:");
                            String ten = sc.nextLine();
                            dskh[i].setTen(ten);
                            break;
                        case 3:
                            System.out.print("Nhap dia chi khach hang:");
                            String diachi = sc.nextLine();
                            dskh[i].setDiaChi(diachi);
                            break;
                        case 4:
                            System.out.println("Nhap SDT khach hang:");
                            String SDT = sc.nextLine();
                            dskh[i].setSoDienThoai(SDT);
                            break;
                        case 5:
                            System.out.print("Nhap email khach hang:");
                            String email = sc.nextLine();
                            dskh[i].setEmail(email);
                            break;
                    }
                }
            }
        }
    }

    public KhachHang TimKHTheoMa(String maKhachHang) {
        KhachHang kq = null;
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (dskh[i].getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
                kq = dskh[i];
                System.out.println("===== THONG TIN KHACH HANG =====");
                System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-25s | %-15s |\n", "Ma khach hang", "Ho", "Ten",
                        "So dien thoai", "Email", "Dia chi");
                kq.xuat();
            }
        }
        return kq;
    }

    public boolean kiemTraMaKhachHang(String maKhachHang) {
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (dskh[i].getMaKhachHang().equalsIgnoreCase(maKhachHang))
                return true;
        }
        return false;
    }

    public KhachHang TimKiemTheoTen(String ten) {
        KhachHang kq = null;
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (dskh[i].getTen().equalsIgnoreCase(ten)) {
                kq = dskh[i];
                System.out.println("===== THONG TIN KHACH HANG =====");
                System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-25s | %-15s |\n", "Ma khach hang", "Ho", "Ten",
                        "So dien thoai", "Email", "Dia chi");
                kq.xuat();
            }
        }
        return kq;
    }

    public void thongKeSoLuongKH() {
        System.out.println("Tong so luong khach hang: " + soLuongKhachHang);
    }

    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("src/data/DanhSachKhachHang.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < soLuongKhachHang; i++) {
                KhachHang khi = (KhachHang) dskh[i];
                bw.write(khi.getMaKhachHang() + "," +
                        khi.getHo() + "," +
                        khi.getTen() + "," +
                        khi.getSoDienThoai() + "," +
                        khi.getEmail() + "," +
                        khi.getDiaChi());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Ghi file thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docFile() {
        try {
            FileReader fr = new FileReader("src/data/DanhSachKhachHang.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
            }
            br.close();
            fr.close();

            dskh = new KhachHang[count];
            soLuongKhachHang = 0;

            FileReader fri = new FileReader("src/data/DanhSachKhachHang.txt");
            BufferedReader bri = new BufferedReader(fri);
            while ((line = bri.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 6) {
                    String maKH = data[0].trim();
                    String ho = data[1].trim();
                    String ten = data[2].trim();
                    String soDienThoai = data[3].trim();
                    String email = data[4].trim();
                    String diaChi = data[5].trim();

                    dskh[soLuongKhachHang] = new KhachHang(maKH, ho, ten, soDienThoai, email, diaChi);
                }
                soLuongKhachHang++;
            }
            bri.close();
            fri.close();
            System.out.println("Doc file thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}