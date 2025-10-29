package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import src.model.nhansu.NhanVien;

public class DanhSachNhanVien {
    private NhanVien[] dsNV;

    // default
    public DanhSachNhanVien() {
        dsNV = new NhanVien[0];
    }

    // parameterized
    public DanhSachNhanVien(NhanVien[] temp) {
        dsNV = temp;
    }

    // copy
    public DanhSachNhanVien(DanhSachNhanVien temp) {
        dsNV = temp.dsNV;
    }

    public NhanVien[] getDS() {
        return dsNV;
    }

    // co the khong can set?
    public void setDS(NhanVien[] temp) {
        dsNV = temp;
    }

    // nhap, xuat, them/xoa, tim kiem, sap xep theo ten/luong/...

    public void chonChucNang() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int choice;
        while (true) {
            System.out.println("""
                    Chon chuc nang can thuc hien!
                    1. Khoi tao danh sach
                    2. Them nhan vien
                    3. Xoa nhan vien
                    4. Sua thong tin nhan vien
                    5. Xuat danh sach nhan vien
                    6. Tim kiem nhan vien
                    7. Sap xep theo ten
                    8. Sap xep theo luong
                    9. Lay du lieu tu file
                    10. Thong ke luong
                    0. Thoat chuong trinh (Tu dong ghi de du lieu vao file)""");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1:
                    khoiTaoDS();
                    break;
                case 2:
                    themNV();
                    break;
                case 3:
                    xoaNV();
                    break;
                case 4:
                    suaThongTin();
                    break;
                case 5:
                    xuatDS();
                    break;
                case 6:
                    timKiemNV();
                    break;
                case 7:
                    sortByTen();
                    break;
                case 8:
                    sortByLuong();
                    break;
                case 9:
                    docFile();
                    break;
                case 10:
                    thongKeLuong();
                    break;
                case 0: {
                    ghiFile();
                    return;
                }
                default:
                    System.out.println("Cu phap khong dung, hay nhap lai!");
                    break;
            }
        }
    }

    public void docFile() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV != null && dsNV.length > 0) {
            System.out.println("Danh sach nhan vien da duoc khoi tao!");

            System.out.print("Co muon lay lai du lieu tu file (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice != 'y' || choice != 'Y') {
                return;
            }
        }

        try {
            FileReader fr = new FileReader("DanhSachNhanVien.txt");
            in = new BufferedReader(fr);

            String line;
            while ((line = in.readLine()) != null) {// kiểm tra còn dữ liệu
                line = line.trim();
                if (line.isEmpty())
                    continue; // bỏ qua dòng trống

                String[] temp = line.split(",");
                if (temp.length == 6) { // kiểm tra có đúng format
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(temp[0].trim());
                    nv.setHo(temp[1].trim());
                    nv.setTen(temp[2].trim());
                    nv.setChucVu(temp[3].trim());
                    nv.setLuong(Float.parseFloat(temp[4].trim()));
                    nv.setSDT(temp[5].trim());

                    dsNV = Arrays.copyOf(dsNV, dsNV.length + 1);
                    dsNV[dsNV.length - 1] = nv;
                } else {
                    System.out.println("Sai format!");
                }

            }
            in.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }

        try {
            FileWriter fw = new FileWriter("DanhSachNhanVien.txt");
            BufferedWriter out = new BufferedWriter(fw);

            for (int i = 0; i < dsNV.length; i++) {
                NhanVien nv = dsNV[i];

                out.write(nv.getMaNV() + ", " + nv.getHo() + ", " + nv.getTen() + ", "
                        + nv.getChucVu() + ", " + nv.getLuong() + ", " + nv.getSDT());
                out.newLine();
            }

            out.close();
            fw.close();

        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public boolean kiemTraMaSoNV(String temp, int locate) {
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i] != null && temp.equals(dsNV[i].getMaNV()) && i != locate) {
                return true;
            }
        }
        return false;
    }

    public void khoiTaoDS() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV != null && dsNV.length > 0) {
            System.out.println("Danh sach nhan vien da duoc khoi tao!");

            System.out.print("Co muon khoi tao lai danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice != 'y' || choice != 'Y') {
                return;
            }
        }

        System.out.print("Nhap so luong nhan vien: ");
        int soLuong = Integer.parseInt(in.readLine());

        dsNV = new NhanVien[soLuong]; // cap phat cho mang

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nguoi thu " + (i + 1) + " - ");
            dsNV[i] = new NhanVien(); // khoi tao doi tuong
            dsNV[i].nhap();
            while (kiemTraMaSoNV(dsNV[i].getMaNV(), i)) {
                System.out.println("Ma so nhan vien da trung! Hay nhap lai!");
                dsNV[i].setMaNV(dsNV[i].hamMaNV());
            }

            System.out.println("____________________________");
        }
    }

    public void xuatDS() throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }

        System.out.println("DANH SACH NHAN VIEN!");
        // In tieu de
        System.out.printf("%-10s %-20s %-15s %-10s %-15s\n",
                "Ma NV", "Ho Ten", "Chuc Vu", "Luong", "SDT");
        System.out.println("--------------------------------------------------------------------------");

        // In danh sach
        for (NhanVien nv : dsNV) {
            String hoTen = nv.getHo() + " " + nv.getTen();
            System.out.printf("%-10s %-20s %-15s %-10.2f %-15s\n",
                    nv.getMaNV(), hoTen, nv.getChucVu(),
                    nv.getLuong(), nv.getSDT());
        }

    }

    public void themNV() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Them bao nhieu nhan vien: ");
        int soLuong = Integer.parseInt(in.readLine());
        dsNV = Arrays.copyOf(dsNV, dsNV.length + soLuong);
        for (int i = dsNV.length - soLuong; i < dsNV.length; i++) {
            System.out.print("Nguoi thu " + (i + 1) + " - ");
            dsNV[i] = new NhanVien(); // khoi tao doi tuong
            dsNV[i].nhap();
            while (kiemTraMaSoNV(dsNV[i].getMaNV(), i)) {
                System.out.println("Ma so nhan vien da trung! Hay nhap lai!");
                dsNV[i].setMaNV(dsNV[i].hamMaNV());
            }
            System.out.println("____________________________");
        }

    }

    public void xoaNV() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }

        if (dsNV == null || dsNV.length == 0 || dsNV.length == 0) {
            System.out.println("Danh sach rong, khong co gi de xoa!");
            return;
        }

        System.out.print("Nhap ma so NV can xoa: ");
        String temp = in.readLine();
        int check = -1;
        for (int i = 0; i < dsNV.length; i++) {
            if (temp.equals(dsNV[i].getMaNV())) {
                check = i;
                break;
            }
        }

        if (check != -1) {
            for (int i = check; i < dsNV.length - 1; i++) {
                dsNV[i] = dsNV[i + 1];
            }
            dsNV = Arrays.copyOf(dsNV, dsNV.length - 1);
        } else {
            System.out.println("Ma so khong tim thay!");
        }

    }

    public void suaThongTin() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Nhap ma so nhan vien can sua: ");
        String temp = in.readLine();
        int check = -1;
        for (int i = 0; i < dsNV.length; i++) {
            if (temp.equals(dsNV[i].getMaNV())) {
                check = i;
                break;
            }
        }

        if (check != -1) {
            dsNV[check].suaThongTin();
        } else {
            System.out.println("Ma so khong tim thay!");
        }
    }

    public void timKiemNV() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Nhap ma so nhan vien can tim: ");
        String temp = in.readLine();

        for (int i = 0; i < dsNV.length; i++) {
            if (temp.equals(dsNV[i].getMaNV())) {
                dsNV[i].xuatNV();
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien can tim!");
    }

    public void sortByTen() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        int choice;
        while (true) {
            System.out.println("""
                    Ban muon sap xep theo kieu nao?
                    1. Sap xep A-z
                    2. Sap xep a-A
                    0. Khong sap xep""");
            choice = Integer.parseInt(in.readLine());
            if (choice == 1) {
                for (int i = 0; i < dsNV.length - 1; i++) {
                    for (int y = 0; y < dsNV.length - i - 1; y++) {
                        if (dsNV[y].getTen().compareToIgnoreCase(dsNV[y + 1].getTen()) > 0) { // >0 -> str1 > str2
                            NhanVien temp = dsNV[y];
                            dsNV[y] = dsNV[y + 1];
                            dsNV[y + 1] = temp;
                        }

                    }
                }
                return;
            } else if (choice == 2) {
                for (int i = 0; i < dsNV.length - 1; i++) {
                    for (int y = 0; y < dsNV.length - i - 1; y++) {
                        if (dsNV[y].getTen().compareToIgnoreCase(dsNV[y + 1].getTen()) < 0) { // <0 -> str1 < str2
                            NhanVien temp = dsNV[y];
                            dsNV[y] = dsNV[y + 1];
                            dsNV[y + 1] = temp;
                        }

                    }
                }
                return;
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("Cu phap khong dung, hay nhap lai!");
            }
        }

    }

    public void sortByLuong() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        int choice;
        while (true) {
            System.out.println("""
                    Ban muon sap xep theo kieu nao?
                    1. Sap xep tu thap den cao
                    2. Sap xep tu cao den thap
                    0. Khong sap xep""");
            choice = Integer.parseInt(in.readLine());

            if (choice == 1) {
                for (int i = 0; i < dsNV.length - 1; i++) {
                    for (int y = 0; y < dsNV.length - i - 1; y++) {
                        if (dsNV[y].getLuong() > dsNV[y + 1].getLuong()) {
                            NhanVien temp = dsNV[y];
                            dsNV[y] = dsNV[y + 1];
                            dsNV[y + 1] = temp;
                        }

                    }
                }
                return;
            } else if (choice == 2) {
                for (int i = 0; i < dsNV.length - 1; i++) {
                    for (int y = 0; y < dsNV.length - i - 1; y++) {
                        if (dsNV[y].getLuong() < dsNV[y + 1].getLuong()) {
                            NhanVien temp = dsNV[y];
                            dsNV[y] = dsNV[y + 1];
                            dsNV[y + 1] = temp;
                        }

                    }
                }
                return;
            } else if (choice == 0) {
                return;
            } else {
                System.out.println("Cu phap khong dung, hay nhap lai!");
            }
        }
    }

    public void thongKeLuong() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNV == null || dsNV.length == 0) {
            System.out.println("Danh sach nhan vien chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        float tongLuong = 0;
        for (int i = 0; i < dsNV.length; i++) {
            tongLuong += dsNV[i].getLuong();
        }
        System.out.println("Tong luong cua nhan vien thang nay la: " + tongLuong);
        int count = 0;
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i].getLuong() > 1200000) {
                count++;
            }
        }
        System.out.println("Tong so nhan vien co luong > 1.200.000 dong: " + count);

    }
}