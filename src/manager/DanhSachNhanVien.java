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
    private int soLuongNV;
    private NhanVien[] dsNV;

    // default
    public DanhSachNhanVien() {
        soLuongNV = 0;
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

    public void setDS(NhanVien[] temp) {
        dsNV = temp;
    }

    public boolean KtraMaNV(String manv) {
        for (int i = 0; i < soLuongNV; i++) {
            if (manv.equalsIgnoreCase(dsNV[i].getMaNV())) {
                return true;
            }
        }
        return false;
    }

    public void docFile() {
        try {
            dsNV = new NhanVien[0];
            soLuongNV = 0;

            BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachNhanVien.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                String[] temp = line.split(",");
                if (temp.length == 6) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(temp[0].trim());
                    nv.setHo(temp[1].trim());
                    nv.setTen(temp[2].trim());
                    nv.setChucVu(temp[3].trim());
                    nv.setLuong(Float.parseFloat(temp[4].trim()));
                    nv.setSDT(temp[5].trim());

                    dsNV = Arrays.copyOf(dsNV, dsNV.length + 1);
                    dsNV[dsNV.length - 1] = nv;
                    soLuongNV++;
                } else {
                    System.out.println("Sai format!");
                }
            }
            br.close();
            System.out.println("Doc file NhanVien thanh cong!");
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
            FileWriter fw = new FileWriter("src/data/DanhSachNhanVien.txt");
            BufferedWriter out = new BufferedWriter(fw);

            for (int i = 0; i < dsNV.length; i++) {
                NhanVien nv = dsNV[i];

                out.write(nv.getMaNV() + ", " + nv.getHo() + ", " + nv.getTen() + ", "
                        + nv.getChucVu() + ", " + nv.getLuong() + ", " + nv.getSDT());
                out.newLine();
            }

            out.close();
            fw.close();
            System.out.println("Ghi file NhanVien thanh cong");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public boolean kiemTraMaSoNV(String temp, int locate) {
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i] != null && temp.equalsIgnoreCase(dsNV[i].getMaNV()) && i != locate) {
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
        System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s\n",
                "Ma NV", "Ho", "Ten", "Chuc Vu", "Luong", "SDT");
        System.out.println("--------------------------------------------------------------------------");

        // In danh sach
        for (NhanVien nv : dsNV) {
            System.out.printf("%-10s %-10s %-10s %-15s %-15.2f %-15s\n",
                    nv.getMaNV(), nv.getHo(), nv.getTen(), nv.getChucVu(),
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
            if (temp.equalsIgnoreCase(dsNV[i].getMaNV())) {
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
            if (temp.equalsIgnoreCase(dsNV[i].getMaNV())) {
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

    public void timKiemNVTheoMa() throws Exception {
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
            if (temp.equalsIgnoreCase(dsNV[i].getMaNV())) {
                dsNV[i].xuatNV();
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien can tim!");
    }

    public void timKiemNVTheoTen() throws Exception {
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
        System.out.print("Nhap ten nhan vien can tim: ");
        String temp = in.readLine();

        for (int i = 0; i < dsNV.length; i++) {
            if (temp.equalsIgnoreCase(dsNV[i].getTen())) {
                dsNV[i].xuatNV();
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien can tim!");
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

    public NhanVien layNV(String maNV) {
        for (int i = 0; i < soLuongNV; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(maNV)) {
                return dsNV[i];
            }
        }
        return null;
    }
}