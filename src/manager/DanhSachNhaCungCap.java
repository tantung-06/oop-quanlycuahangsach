package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import src.model.doitac.NhaCungCap;

public class DanhSachNhaCungCap {
    private NhaCungCap[] dsncc;
    private int soptu;

    public DanhSachNhaCungCap() {
        soptu = 0;
        dsncc = new NhaCungCap[0];
    }

    public void docfile() {
        try {
            dsncc = new NhaCungCap[0];
            soptu = 0;

            BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachNhaCungCap.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                String[] part = line.split("\\s*,\\s*");
                if (part.length == 4) {
                    String mancc = part[0];
                    String ten = part[1];
                    String sdt = part[2];
                    String diachi = part[3];

                    NhaCungCap ncc = new NhaCungCap(mancc, ten, sdt, diachi);
                    dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
                    dsncc[dsncc.length - 1] = ncc;
                    soptu++;
                } else {
                    System.out.println("Sai format NCC: " + line);
                }
            }

            br.close();
            System.out.println("Doc file NhaCungCap thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public boolean KiemTraMaNCC(String ma) {
        for (int i = 0; i < soptu; i++) {
            if (dsncc[i].getMaNCC().equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }

    public void ThemNcc() {
        Scanner sc = new Scanner(System.in);
        NhaCungCap ncc = new NhaCungCap();
        String mancc;

        do {
            System.out.print("Nhap ma nha cung cap can them: ");
            mancc = sc.nextLine();
            if (KiemTraMaNCC(mancc)) {
                System.out.println("Bi trung ma nha cung cap, vui long nhap lai");
            }
        } while (KiemTraMaNCC(mancc));

        ncc.setMaNCC(mancc);
        ncc.nhap();

        dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
        dsncc[dsncc.length - 1] = ncc;
        soptu++;

        System.out.println("Them nha cung cap thanh cong!");
    }

    public void XoaNccTheoMa(String ma) {
        boolean timThay = false;
        for (int i = 0; i < soptu; i++) {
            if (dsncc[i].getMaNCC().equalsIgnoreCase(ma)) {
                timThay = true;
                for (int j = i; j < soptu - 1; j++) {
                    dsncc[j] = dsncc[j + 1];
                }
                dsncc = Arrays.copyOf(dsncc, dsncc.length - 1);
                soptu--;
                System.out.println("Xoa nha cung cap thanh cong!");
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay ma nha cung cap!");
        }
    }

    public void SuaNcc(String ma) {
        Scanner sc = new Scanner(System.in);
        boolean tim = false;

        for (int i = 0; i < soptu; i++) {
            if (dsncc[i].getMaNCC().equalsIgnoreCase(ma)) {
                tim = true;
                int chon;

                do {
                    System.out.println("===== SUA THONG TIN NHA CUNG CAP =====");
                    System.out.println("1. Sua ten");
                    System.out.println("2. Sua so dien thoai");
                    System.out.println("3. Sua dia chi");
                    System.out.println("0. Thoat");
                    System.out.print("Vui long chon: ");
                    chon = sc.nextInt();
                    sc.nextLine();

                    switch (chon) {
                        case 1:
                            System.out.print("Nhap ten moi: ");
                            dsncc[i].setTen(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhap so dien thoai moi: ");
                            dsncc[i].setSoDienThoai(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap dia chi moi: ");
                            dsncc[i].setDiaChi(sc.nextLine());
                            break;
                        case 0:
                            System.out.println("Da thoat");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le");
                            break;
                    }
                } while (chon != 0);
                break;
            }
        }

        if (!tim) {
            System.out.println("Khong tim thay ma nha cung cap!");
        }
    }

    public NhaCungCap TimNccTheoMa(String ma) {
        System.out.printf("| %-20s | %-35s | %-20s | %-20s |\n",
                "Ma nha cung cap", "Ten", "So dien thoai", "Dia chi");
        for (int i = 0; i < soptu; i++) {
            if (dsncc[i].getMaNCC().equalsIgnoreCase(ma)) {
                dsncc[i].xuat();
                return dsncc[i];
            }
        }
        System.out.println("Khong tim thay nha cung cap!");
        return null;
    }

    public NhaCungCap TimNccTheoTen(String ten) {
        System.out.printf("| %-20s | %-35s | %-20s | %-20s |\n",
                "Ma nha cung cap", "Ten", "So dien thoai", "Dia chi");
        for (int i = 0; i < soptu; i++) {
            if (dsncc[i].getTen().equalsIgnoreCase(ten)) {
                dsncc[i].xuat();
                return dsncc[i];
            }
        }
        System.out.println("Khong tim thay nha cung cap!");
        return null;
    }

    public int ThongKeNcc() {
        System.out.println("Tong so nha cung cap: " + soptu);
        return soptu;
    }

    public void ghifile() {
        try {
            FileWriter fw = new FileWriter("src/data/DanhSachNhaCungCap.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < soptu; i++) {
                NhaCungCap nhacc = dsncc[i];
                bw.write(nhacc.getMaNCC() + ", " + nhacc.getTen() + ", " +
                        nhacc.getSoDienThoai() + ", " + nhacc.getDiaChi());
                bw.newLine();
            }

            bw.close();
            fw.close();
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void XuatDs() {
        if (dsncc == null || soptu == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("========= DANH SACH NHA CUNG CAP ==========");
        System.out.printf("| %-20s | %-35s | %-20s | %-20s |\n",
                "Ma nha cung cap", "Ten", "So dien thoai", "Dia chi");
        for (int i = 0; i < soptu; i++) {
            dsncc[i].xuat();
        }
    }

    public NhaCungCap layNCC(String maNCC) {
        for (int i = 0; i < soptu; i++) {
            if (dsncc[i].getMaNCC().equalsIgnoreCase(maNCC)) {
                return dsncc[i];
            }
        }
        return null;
    }
}