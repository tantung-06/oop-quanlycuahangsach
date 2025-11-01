package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import src.model.doitac.KhachHang;

public class DanhSachKhachHang {
    private int n;
    private KhachHang[] kh;

    public DanhSachKhachHang() {
        n = 0;
        kh = new KhachHang[0];
    }

    // Kiểm tra mã khách hàng có trùng không
    public boolean kiemTraMaKH(String maKH, int soLuongHienTai) {
        for (int i = 0; i < soLuongHienTai; i++) {
            if (kh[i].getMaKH().equalsIgnoreCase(maKH)) {
                return true;
            }
        }
        return false;
    }

    // Nhập khách hàng
    public void nhapKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang: ");
        n = sc.nextInt();
        sc.nextLine();

        kh = new KhachHang[n];

        for (int i = 0; i < n; i++) {
            System.out.println("----- Thong tin khach hang thu " + (i + 1) + " -----");

            kh[i] = new KhachHang();

            String maKH;
            do {
                System.out.print("Nhap ma khach hang: ");
                maKH = sc.nextLine();
                if (kiemTraMaKH(maKH, i)) {
                    System.out.println("Ma da ton tai, vui long nhap lai!");
                }
            } while (kiemTraMaKH(maKH, i));

            kh[i].setMaKH(maKH);
            kh[i].nhapKhongMa();
        }

    }

    // Xuất danh sách khách hàng
    public void xuatKhachHang() {
        if (n == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        System.out.println("----- Danh sách khách hàng -----");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Ma khach hang", "Ho", "Ten",
                "So dien thoai", "Email", "Dia chi");
        for (int i = 0; i < n; i++) {
            kh[i].xuat();
        }
    }

    // Thêm khách hàng
    public void themKhachHang() {
        Scanner sc = new Scanner(System.in);
        KhachHang x = new KhachHang();

        String maKH;
        do {
            System.out.print("Nhap ma khach hang: ");
            maKH = sc.nextLine();
            if (kiemTraMaKH(maKH, n)) {
                System.out.println("Ma da ton tai, vui long nhap lai!");
            }
        } while (kiemTraMaKH(maKH, n));

        x.setMaKH(maKH);
        x.nhapKhongMa();

        kh = Arrays.copyOf(kh, n + 1);
        kh[n] = x;
        n++;
    }

    // Xóa khách hàng theo mã
    public void xoaKhachHang() {
        if (n == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can xoa: ");
        String maKH = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < n; i++) {
            if (kh[i].getMaKH().equalsIgnoreCase(maKH)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay khach hang co ma: " + maKH);
            return;
        }

        for (int i = viTri; i < n - 1; i++) {
            kh[i] = kh[i + 1];
        }

        n--;
        kh = Arrays.copyOf(kh, n);
    }

    // Sửa thông tin khách hàng
    public void suaKhachHang() {
        if (n == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can sua: ");
        String maKH = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < n; i++) {
            if (kh[i].getMaKH().equalsIgnoreCase(maKH)) {
                viTri = i;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay khach hang co ma: " + maKH);
            return;
        }

        int lc;
        do {
            System.out.println("1. Ho \n2. Ten \n3. So dien thoai \n4. Email \n5. Dia chi \n0. Thoat");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    System.out.print("Nhap ho moi: ");
                    kh[viTri].setHo(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ten moi: ");
                    kh[viTri].setTen(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap so dien thoai moi: ");
                    kh[viTri].setSoDienThoai(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap email moi: ");
                    kh[viTri].setEmail(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap dia chi moi: ");
                    kh[viTri].setDiaChi(sc.nextLine());
                    break;
                case 0:
                    System.out.println("Thoat!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (lc != 0);
    }

    // === Tìm kiếm ===
    // Tìm kiếm khách hàng theo mã
    public void timKiemKHTheoMa() {
        if (n == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        boolean timThay = false;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can tim: ");
        String maKH = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (kh[i].getMaKH().equalsIgnoreCase(maKH)) {
                kh[i].xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay khach hang co ma: " + maKH);
        }
    }

    // Tìm kiếm khách hàng theo tên
    public void timKiemKHTheoTen() {
        if (n == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten khach hang can tim: ");
        String ten = sc.nextLine();

        boolean timThay = false;

        for (int i = 0; i < n; i++) {
            if (kh[i].getTen().equalsIgnoreCase(ten)) {
                kh[i].xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay khach hang co ten: " + ten);
        }
    }

    // === Thống kê ===

    // === Đọc - Ghi file ===
    // Đọc file
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

            kh = new KhachHang[count];
            n = 0;

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

                    kh[n] = new KhachHang(maKH, ho, ten, soDienThoai, email, diaChi);
                }
                n++;
            }
            bri.close();
            fri.close();
            System.out.println("Doc file thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // // Ghi file
    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("src/data/DanhSachKhachHang.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < n; i++) {
                KhachHang khi = (KhachHang) kh[i];
                bw.write(khi.getMaKH() + "," +
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
            e.printStackTrace();
        }
    }
}