package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import src.model.sach.TacGia;

public class DanhSachTacGia {
    private TacGia[] dsTG;

    public DanhSachTacGia() {
        dsTG = new TacGia[0];
    }

    public DanhSachTacGia(TacGia[] dsTG) {
        this.dsTG = dsTG;
    }

    public DanhSachTacGia(DanhSachTacGia dsdsTG) {
        this.dsTG = dsdsTG.dsTG;
    }

    public TacGia[] getTG() {
        return dsTG;
    }

    public void setTG(TacGia[] dsTG) {
        this.dsTG = dsTG;
    }

    public void chonChucNang() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int choice;
        while (true) {
            System.out.println("""
                    Chon chuc nang can thuc hien!
                    1. Khoi tao danh sach
                    2. Them tac gia
                    3. Xoa tac gia
                    4. Sua thong tin tac gia
                    5. Xuat danh sach tac gia
                    6. Tim kiem tac gia
                    7. Sap xep theo ten
                    8. Lay du lieu tu file
                    9. Thong ke tuoi tac gia
                    0. Thoat chuong trinh (Tu dong ghi de du lieu vao file)""");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1:
                    khoiTaoDS();
                    break;
                case 2:
                    themTG();
                    break;
                case 3:
                    xoaTG();
                    break;
                case 4:
                    suaThongTin();
                    break;
                case 5:
                    xuatDS();
                    break;
                case 6:
                    timKiemTG();
                    break;
                case 7:
                    sortByTen();
                    break;
                case 8:
                    docFile();
                    break;
                case 9:
                    thongKeTuoi();
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
        if (dsTG != null && dsTG.length > 0) {
            System.out.println("Danh sach tac gia da duoc khoi tao!");

            System.out.print("Co muon lay lai du lieu tu file (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice != 'y' || choice != 'Y') {
                return;
            }
        }
        try {
            FileReader fr = new FileReader("DanhSachTacGia.txt");
            in = new BufferedReader(fr);

            String line;
            while ((line = in.readLine()) != null) {// kiểm tra còn dữ liệu
                line = line.trim();
                if (line.isEmpty())
                    continue; // bỏ qua dòng trống

                String[] temp = line.split(",");
                if (temp.length == 4) { // kiểm tra có đúng format
                    TacGia tg = new TacGia();
                    tg.setMaTG(temp[0].trim());
                    tg.setTen(temp[1].trim());
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate ngaySinh = LocalDate.parse(temp[2].trim(), fmt);
                    tg.setNgaySinh(ngaySinh);
                    tg.setQuocTich(temp[3].trim());

                    dsTG = Arrays.copyOf(dsTG, dsTG.length + 1);
                    dsTG[dsTG.length - 1] = tg;
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
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

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
            FileWriter fw = new FileWriter("DanhSachTacGia.txt");
            BufferedWriter out = new BufferedWriter(fw);

            for (int i = 0; i < dsTG.length; i++) {
                TacGia tg = dsTG[i];

                out.write(tg.getMaTG() + ", " + tg.getTen() + ", "
                        + tg.getNgaySinh() + ", " + tg.getQuocTich());
                out.newLine();
            }
            out.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public boolean kiemTraMaSoTG(String temp, int locate) {
        for (int i = 0; i < dsTG.length; i++) {
            if (dsTG[i] != null && temp.equals(dsTG[i].getMaTG()) && i != locate) {
                return true;
            }
        }
        return false;
    }

    public void khoiTaoDS() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG != null && dsTG.length > 0) {
            System.out.println("Danh sach tac gia da duoc khoi tao!");

            System.out.print("Co muon lay lai du lieu tu file (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice != 'y' || choice != 'Y') {
                return;
            }
        }
        System.out.print("Nhap so luong can khoi tao: ");
        int soLuong = Integer.parseInt(in.readLine());

        dsTG = new TacGia[soLuong];

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nha xuat ban " + (i + 1) + " - ");
            dsTG[i] = new TacGia(); // khoi tao doi tuong
            dsTG[i].nhap();
            while (kiemTraMaSoTG(dsTG[i].getMaTG(), i)) {
                System.out.println("Ma so nhan vien da trung! Hay nhap lai!");
                dsTG[i].setMaTG(dsTG[i].hamMaTG());
            }
            System.out.println("____________________________");
        }
    }

    public void xuatDS() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.println("DANH SACH TAC GIA!");
        // In tiêu đề
        System.out.printf("%-10s %-25s %-15s %-20s\n",
                "Ma TG", "Ten TG", "Ngay Sinh", "Quoc Tich");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");

        // In danh sách
        for (TacGia temp : dsTG) { // dsTG là danh sách các tác giả
            // Chuyển ngày sinh từ int[] sang dạng dd/mm/yyyy
            LocalDate d = temp.getNgaySinh();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf("%-10s %-25s %-15s %-20s\n",
                    temp.getMaTG(), temp.getTen(), d.format(fmt), temp.getQuocTich());
        }
    }

    public void themTG() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Them bao nhieu tac gia: ");
        int soLuong = Integer.parseInt(in.readLine());
        dsTG = Arrays.copyOf(dsTG, dsTG.length + soLuong);
        for (int i = dsTG.length - soLuong; i < dsTG.length; i++) {
            System.out.print("Nguoi thu " + (i + 1) + " - ");
            dsTG[i] = new TacGia(); // khoi tao doi tuong
            dsTG[i].nhap();
            while (kiemTraMaSoTG(dsTG[i].getMaTG(), i)) {
                System.out.println("Ma so nhan vien da trung! Hay nhap lai!");
                dsTG[i].setMaTG(dsTG[i].hamMaTG());
            }
            System.out.println("____________________________");
            System.out.println("____________________________");
        }
    }

    public void xoaTG() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }

        if (dsTG == null || dsTG.length == 0 || dsTG.length == 0) {
            System.out.println("Danh sach rong, khong co gi de xoa!");
            return;
        }

        System.out.print("Nhap ma so TG can xoa: ");
        String temp = in.readLine();
        int check = -1;
        for (int i = 0; i < dsTG.length; i++) {
            if (temp.equals(dsTG[i].getMaTG())) {
                check = i;
                break;
            }
        }

        if (check != -1) {
            for (int i = check; i < dsTG.length - 1; i++) {
                dsTG[i] = dsTG[i + 1];
            }
            dsTG = Arrays.copyOf(dsTG, dsTG.length - 1);
        } else {
            System.out.println("Ma so khong tim thay!");
        }
    }

    public void suaThongTin() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Nhap ma so tac gia can sua: ");
        String temp = in.readLine();
        int check = -1;
        for (int i = 0; i < dsTG.length; i++) {
            if (temp.equals(dsTG[i].getMaTG())) {
                check = i;
                break;
            }
        }

        if (check != -1) {
            dsTG[check].suaThongTin();
        } else {
            System.out.println("Ma so khong tim thay!");
        }
    }

    public void timKiemTG() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Nhap ma so tac gia can tim: ");
        String temp = in.readLine();

        for (int i = 0; i < dsTG.length; i++) {
            if (temp.equals(dsTG[i].getMaTG())) {
                dsTG[i].xuat();
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien can tim!");
    }

    public void sortByTen() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

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
                for (int i = 0; i < dsTG.length - 1; i++) {
                    for (int y = 0; y < dsTG.length - i - 1; y++) {
                        if (dsTG[y].getTen().compareToIgnoreCase(dsTG[y + 1].getTen()) > 0) { // >0 -> str1 > str2
                            TacGia temp = dsTG[y];
                            dsTG[y] = dsTG[y + 1];
                            dsTG[y + 1] = temp;
                        }

                    }
                }
                return;
            } else if (choice == 2) {
                for (int i = 0; i < dsTG.length - 1; i++) {
                    for (int y = 0; y < dsTG.length - i - 1; y++) {
                        if (dsTG[y].getTen().compareToIgnoreCase(dsTG[y + 1].getTen()) < 0) { // <0 -> str1 < str2
                            TacGia temp = dsTG[y];
                            dsTG[y] = dsTG[y + 1];
                            dsTG[y + 1] = temp;
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

    public void thongKeTuoi() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsTG == null || dsTG.length == 0) {
            System.out.println("Danh sach tac gia chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        int count = 0;
        for (int i = 0; i < dsTG.length; i++) {
            int tuoi = Period.between(dsTG[i].getNgaySinh(), LocalDate.now()).getYears();
            if (tuoi > 36) {
                count++;
            }
        }

        System.out.println("Tong so tac gia co tuoi > 36 la: " + count);

    }

}