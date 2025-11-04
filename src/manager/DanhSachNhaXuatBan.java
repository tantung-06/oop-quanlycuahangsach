package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import src.model.sach.NhaXuatBan;

public class DanhSachNhaXuatBan {
    private int soLuongNXB;
    private NhaXuatBan[] dsNXB;

    public DanhSachNhaXuatBan() {
        soLuongNXB = 0;
        dsNXB = new NhaXuatBan[0];
    }

    public DanhSachNhaXuatBan(NhaXuatBan[] dsNXB) {
        this.dsNXB = dsNXB;
    }

    public DanhSachNhaXuatBan(DanhSachNhaXuatBan dsdsNXB) {
        dsNXB = dsdsNXB.dsNXB;
    }

    public NhaXuatBan[] getNXB() {
        return dsNXB;
    }

    public void setNXB(NhaXuatBan[] temp) {
        dsNXB = temp;
    }

    public void docFile() {
        try {
            dsNXB = new NhaXuatBan[0];
            soLuongNXB = 0;

            BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachNhaXuatBan.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                String[] temp = line.split("\\s*,\\s*");
                if (temp.length != 3) {
                    System.out.println("Sai format NXB: " + line);
                    continue;
                }

                try {
                    NhaXuatBan nxb = new NhaXuatBan();
                    nxb.setMaNXB(temp[0]);
                    nxb.setTenNXB(temp[1]);
                    nxb.setDiaChi(temp[2]);

                    dsNXB = Arrays.copyOf(dsNXB, dsNXB.length + 1);
                    dsNXB[dsNXB.length - 1] = nxb;
                    soLuongNXB++;
                } catch (Exception e) {
                    System.out.println("Loi du lieu NXB: " + line);
                }
            }

            br.close();
            System.out.println("Doc file NXB thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file NXB: " + e.getMessage());
        }
    }

    public void ghiFile() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0 || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

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
            FileWriter fw = new FileWriter("src/data/DanhSachNhaXuatBan.txt");
            BufferedWriter out = new BufferedWriter(fw);

            for (int i = 0; i < dsNXB.length; i++) {
                NhaXuatBan nxb = dsNXB[i];

                out.write(nxb.getMaNXB() + ", " + nxb.getTenNXB() + ", " + nxb.getDiaChi());
                out.newLine();
            }
            out.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public boolean kiemTraMaSoNXB(String temp, int locate) {
        for (int i = 0; i < dsNXB.length; i++) {
            if (dsNXB[i] != null && temp.equalsIgnoreCase(dsNXB[i].getMaNXB()) && i != locate) {
                return true;
            }
        }
        return false;
    }

    public void khoiTaoDS() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB != null && dsNXB.length > 0) {
            System.out.println("Danh sach nha xuat ban da duoc khoi tao!");

            System.out.print("Co muon khoi tao lai danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice != 'y' || choice != 'Y') {
                return;
            }
        }
        System.out.print("Nhap so luong can khoi tao: ");
        int soLuong = Integer.parseInt(in.readLine());

        dsNXB = new NhaXuatBan[soLuong];

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nha xuat ban " + (i + 1) + " - ");
            dsNXB[i] = new NhaXuatBan();
            dsNXB[i].nhap();
            while (kiemTraMaSoNXB(dsNXB[i].getMaNXB(), i)) {
                System.out.println("Ma so nhan vien da trung! Hay nhap lai!");
                dsNXB[i].setMaNXB(dsNXB[i].hamMaNXB());
            }
            System.out.println("____________________________");
        }
    }

    public void xuatDS() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.println("DANH SACH NHA XUAT BAN!");
        System.out.printf("%-10s %-30s %-30s\n",
                "Ma NXB", "Ten NXB", "Dia Chi");
        System.out.println("--------------------------------------------------------------------------");

        for (NhaXuatBan temp : dsNXB) {
            System.out.printf("%-10s %-30s %-30s\n",
                    temp.getMaNXB(), temp.getTenNXB(), temp.getDiaChi());
        }
    }

    public void themNXB() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Them bao nhieu nha xuat ban: ");
        int soLuong = Integer.parseInt(in.readLine());
        dsNXB = Arrays.copyOf(dsNXB, dsNXB.length + soLuong);
        for (int i = dsNXB.length - soLuong; i < dsNXB.length; i++) {
            System.out.print("Nguoi thu " + (i + 1) + " - ");
            dsNXB[i] = new NhaXuatBan();
            dsNXB[i].nhap();
            while (kiemTraMaSoNXB(dsNXB[i].getMaNXB(), i)) {
                System.out.println("Ma so nhan vien da trung! Hay nhap lai!");
                dsNXB[i].setMaNXB(dsNXB[i].hamMaNXB());
            }
            System.out.println("____________________________");
        }
    }

    public void xoaNXB() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }

        if (dsNXB == null || dsNXB.length == 0 || dsNXB.length == 0) {
            System.out.println("Danh sach rong, khong co gi de xoa!");
            return;
        }

        System.out.print("Nhap ma so NXB can xoa: ");
        String temp = in.readLine();
        int check = -1;
        for (int i = 0; i < dsNXB.length; i++) {
            if (temp.equalsIgnoreCase(dsNXB[i].getMaNXB())) {
                check = i;
                break;
            }
        }

        if (check != -1) {
            for (int i = check; i < dsNXB.length - 1; i++) {
                dsNXB[i] = dsNXB[i + 1];
            }
            dsNXB = Arrays.copyOf(dsNXB, dsNXB.length - 1);
        } else {
            System.out.println("Ma so khong tim thay!");
        }
    }

    public void suaThongTin() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Nhap ma so nha xuat ban can sua: ");
        String temp = in.readLine();
        int check = -1;
        for (int i = 0; i < dsNXB.length; i++) {
            if (temp.equalsIgnoreCase(dsNXB[i].getMaNXB())) {
                check = i;
                break;
            }
        }

        if (check != -1) {
            dsNXB[check].suaThongTin();
        } else {
            System.out.println("Ma so khong tim thay!");
        }
    }

    public void timKiemNXBTheoMa() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Nhap ma so nha xuat ban can tim: ");
        String temp = in.readLine();

        for (int i = 0; i < dsNXB.length; i++) {
            if (temp.equalsIgnoreCase(dsNXB[i].getMaNXB())) {
                dsNXB[i].xuat();
                return;
            }
        }

        System.out.println("Khong tim thay nha xuat ban can tim!");
    }

    public void timKiemNXBTheoTen() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        System.out.print("Nhap ten nha xuat ban can tim: ");
        String temp = in.readLine();

        for (int i = 0; i < dsNXB.length; i++) {
            if (temp.equalsIgnoreCase(dsNXB[i].getTenNXB())) {
                dsNXB[i].xuat();
                return;
            }
        }

        System.out.println("Khong tim thay nha xuat ban can tim!");
    }

    public void thongKeThanhPho() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (dsNXB == null || dsNXB.length == 0) {
            System.out.println("Danh sach nha xuat ban chua duoc khoi tao!");

            System.out.print("Co muon khoi tao danh sach (y/n): ");
            char choice;
            choice = in.readLine().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                khoiTaoDS();
                return;
            }
            return;
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < dsNXB.length; i++) {
            String[] temp = dsNXB[i].getDiaChi().split(",");
            String thanhPho = temp[temp.length - 1].trim();

            if (thanhPho.equalsIgnoreCase("TP.HCM"))
                count1++;
            else if (thanhPho.equalsIgnoreCase("Hà Nội"))
                count2++;
        }

        System.out.println("Tong so nha xuat ban o Ho Chi Minh: " + count1);
        System.out.println("Tong so nha xuat ban o Ha Noi: " + count2);
    }

    public boolean kiemTraMaNXB(String maNXB) {
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equalsIgnoreCase(maNXB))
                return true;
        }
        return false;
    }

    public NhaXuatBan layNXB(String maNXB) {
        for (int i = 0; i < soLuongNXB; i++) {
            if (dsNXB[i].getMaNXB().equalsIgnoreCase(maNXB))
                return dsNXB[i];
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        DanhSachNhaXuatBan dsnxb = new DanhSachNhaXuatBan();
        dsnxb.docFile();
        dsnxb.xuatDS();
        System.out.println(dsnxb.layNXB("NXB01"));
    }

}