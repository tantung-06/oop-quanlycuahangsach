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
    private int soLuongTG;
    private TacGia[] dsTG;

    public DanhSachTacGia() {
        soLuongTG = 0;
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

    public void docFile() {
        try {
            dsTG = new TacGia[0];
            soLuongTG = 0;

            BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachTacGia.txt"));
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                String[] temp = line.split("\\s*,\\s*");
                if (temp.length != 4) {
                    System.out.println("Sai format TacGia: " + line);
                    continue;
                }

                try {
                    TacGia tg = new TacGia();
                    tg.setMaTG(temp[0]);
                    tg.setTen(temp[1]);
                    tg.setNgaySinh(LocalDate.parse(temp[2], fmt));
                    tg.setQuocTich(temp[3]);

                    dsTG = Arrays.copyOf(dsTG, dsTG.length + 1);
                    dsTG[dsTG.length - 1] = tg;
                    soLuongTG++;
                } catch (Exception e) {
                    System.out.println("Loi du lieu TacGia: " + line);
                }
            }

            br.close();
            System.out.println("Doc file TacGia thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file TacGia: " + e.getMessage());
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
            FileWriter fw = new FileWriter("src/data/DanhSachTacGia.txt");
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
            if (dsTG[i] != null && temp.equalsIgnoreCase(dsTG[i].getMaTG()) && i != locate) {
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
            dsTG[i] = new TacGia();
            dsTG[i].nhap();
            while (kiemTraMaSoTG(dsTG[i].getMaTG(), i)) {
                System.out.println("Ma so nhan vien da trung! Hay nhap lai!");
                dsTG[i].setMaTG(dsTG[i].hamMaTG());
            }
            System.out.println("____________________________");
        }
    }

    // Xuất danh sách
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
        System.out.printf("%-10s %-25s %-15s %-20s\n",
                "Ma TG", "Ten TG", "Ngay Sinh", "Quoc Tich");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
        for (TacGia temp : dsTG) {
            LocalDate d = temp.getNgaySinh();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf("%-10s %-25s %-15s %-20s\n",
                    temp.getMaTG(), temp.getTen(), d.format(fmt), temp.getQuocTich());
        }
    }

    // Thêm
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
            dsTG[i] = new TacGia();
            dsTG[i].nhap();
            while (kiemTraMaSoTG(dsTG[i].getMaTG(), i)) {
                System.out.println("Ma so tac gia da trung! Hay nhap lai!");
                dsTG[i].setMaTG(dsTG[i].hamMaTG());
            }
            System.out.println("____________________________");
            System.out.println("____________________________");
        }
    }

    // Xóa
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
            if (temp.equalsIgnoreCase(dsTG[i].getMaTG())) {
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

    // Sửa thông tin
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
            if (temp.equalsIgnoreCase(dsTG[i].getMaTG())) {
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

    // Tìm kiếm theo mã
    public void timKiemTGTheoMa() throws Exception {
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
            if (temp.equalsIgnoreCase(dsTG[i].getMaTG())) {
                dsTG[i].xuat();
                return;
            }
        }

        System.out.println("Khong tim thay tac gia can tim!");
    }

    // Tìm kiếm theo tên
    public void timKiemTGTheoTen() throws Exception {
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
        System.out.print("Nhap ten tac gia can tim: ");
        String temp = in.readLine();

        for (int i = 0; i < dsTG.length; i++) {
            if (temp.equalsIgnoreCase(dsTG[i].getTen())) {
                dsTG[i].xuat();
                return;
            }
        }

        System.out.println("Khong tim thay tac gia can tim!");
    }

    // Thống kê tuổi
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

    public boolean kiemTraMaTG(String maTG) {
        for (int i = 0; i < soLuongTG; i++) {
            if (dsTG[i].getMaTG().equalsIgnoreCase(maTG))
                return true;
        }
        return false;
    }

    // cho class sách - tùng
    public TacGia layTacGia(String maTG) {
        for (int i = 0; i < soLuongTG; i++) {
            if (dsTG[i].getMaTG().equalsIgnoreCase(maTG))
                return dsTG[i];
        }
        return null;
    }
    //

    public static void main(String[] args) {
        try {
            DanhSachTacGia dstg = new DanhSachTacGia();
            dstg.docFile();
            dstg.xuatDS();
            System.out.println(dstg.layTacGia("TG001"));
            System.out.println(dstg.soLuongTG);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}