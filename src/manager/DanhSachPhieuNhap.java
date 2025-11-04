package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import src.model.doitac.NhaCungCap;
import src.model.nhansu.NhanVien;
import src.model.phieunhap.ChiTietPhieuNhap;
import src.model.phieunhap.PhieuNhap;
import src.model.sach.NhaXuatBan;
import src.model.sach.Sach;

public class DanhSachPhieuNhap {
    private int soptu;
    private PhieuNhap[] dspn;
    private DanhSachNhaCungCap dsncc;
    private DanhSachNhanVien dsnv;

    public DanhSachPhieuNhap() {
        soptu = 0;
        dspn = new PhieuNhap[0];
        dsncc = new DanhSachNhaCungCap();
        dsnv = new DanhSachNhanVien();
    }

    public void docfile() {
        try {
            dsncc.docfile();
            dsnv.docFile();

            BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachPhieuNhap.txt"));
            String line;

            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
            }
            br.close();

            dspn = new PhieuNhap[count];
            soptu = 0;

            BufferedReader br1 = new BufferedReader(new FileReader("src/data/DanhSachPhieuNhap.txt"));

            while ((line = br1.readLine()) != null) {
                String[] part = line.split(",");
                if (part.length == 5) {
                    String mapn = part[0].trim();
                    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate tgian = LocalDate.parse(part[1].trim(), f);
                    double tongtien = Long.parseLong(part[2].trim());
                    String mancc = part[3].trim();
                    String manv = part[4].trim();

                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setMaNCC(mancc);

                    NhanVien nv = new NhanVien();
                    nv.setMaNV(manv);

                    dspn[soptu] = new PhieuNhap(mapn, tgian, tongtien, ncc, nv);
                    soptu++;
                }
            }
            br1.close();
            System.out.println("doc file thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Xuatds() {
        if (soptu == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("===== DANH SACH PHIEU NHAP =====");
        System.out.printf("| %-20s | %-15s | %-15s | %-20s | %-15s |\n", "Ma phieu nhap", "Ngay lap", "Tong tien",
                "Ma nha cung cap", "Ma nhan vien");
        for (int i = 0; i < soptu; i++) {
            dspn[i].xuat();
        }
    }

    public void ThemPN() {
        Scanner sc = new Scanner(System.in);
        PhieuNhap pn = new PhieuNhap();

        String mapn;
        do {
            System.out.print("Nhap ma phieu nhap");
            mapn = sc.nextLine();
            if (KtraMaPn(mapn)) {
                System.out.println("Ma phieu nhap da ton tai, vui long nhap lai!");
            }
        } while (KtraMaPn(mapn));
        pn.setMaPN(mapn);
        pn.nhap(dsncc, dsnv);

        dspn = Arrays.copyOf(dspn, soptu + 1);
        dspn[soptu] = pn;
        soptu++;
    }

    public void XoaPNTheoMaPN(String mapn) {
        boolean tim = false;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getMaPN().equalsIgnoreCase(mapn)) {
                for (int j = i; j < soptu - 1; j++) {
                    dspn[j] = dspn[j + 1];
                }
                soptu--;
                dspn = Arrays.copyOf(dspn, soptu);
                tim = true;
                System.out.println("da xoa phieu nhap co ma " + mapn);
                break;
            }
        }
        if (!tim) {
            System.out.println("khong tim thay phieu nhap can xoa ");
        }
    }

    public PhieuNhap[] TimKiemPnTheoMaNCC(String mancc) {
        int dem = 0;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getNhaCungCap().getMaNCC().equalsIgnoreCase(mancc)) {
                dspn[i].xuat();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("khong co phieu nhap nao co ma nha cung cap tren");
        }
        PhieuNhap[] kq = new PhieuNhap[dem];
        int a = 0;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getNhaCungCap().getMaNCC().equalsIgnoreCase(mancc)) {
                kq[a++] = dspn[i];
            }
        }
        return kq;
    }

    public PhieuNhap[] TimKiemPnTheoMaPN(String mapn) {
        int dem = 0;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getMaPN().equalsIgnoreCase(mapn)) {
                dspn[i].xuat();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("khong co phieu nhap nao co ma phieu nhap tren");
        }
        PhieuNhap[] kq = new PhieuNhap[dem];
        int a = 0;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getMaPN().equalsIgnoreCase(mapn)) {
                kq[a++] = dspn[i];
            }
        }
        return kq;
    }

    public PhieuNhap[] TimKiemPnTheoMaNV(String manv) {
        int dem = 0;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getNhanVien().getMaNV().equalsIgnoreCase(manv)) {
                dspn[i].xuat();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("khong co phieu nhap nao co ma nhan vien tren");
        }
        PhieuNhap[] kq = new PhieuNhap[dem];
        int a = 0;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getNhanVien().getMaNV().equalsIgnoreCase(manv)) {
                kq[a++] = dspn[i];
            }
        }
        return kq;
    }

    public void suaPhieuNhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu nhap can sua: ");
        String maPN = sc.nextLine();

        boolean timThay = false;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getMaPN().equalsIgnoreCase(maPN)) {
                timThay = true;
                int lc;
                do {
                    System.out.println("""
                            ===== SUA THONG TIN PHIEU NHAP =====
                            1. Sua ngay lap
                            2. Sua ma nha cung cap
                            3. Sua ma nhan vien
                            0. Thoat!
                            """);
                    System.out.print("Nhap lua chon: ");
                    lc = sc.nextInt();
                    sc.nextLine();

                    switch (lc) {
                        case 1:
                            System.out.print("Nhap ngay lap moi");
                            String nl = sc.nextLine();
                            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            dspn[i].setNgayLap(LocalDate.parse(nl, f));
                            break;
                        case 2:
                            System.out.print("Nhap ma nha cung cap moi: ");
                            dspn[i].getNhaCungCap().setMaNCC(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhap ma nhan vien moi: ");
                            dspn[i].getNhanVien().setMaNV(sc.nextLine());
                            break;
                        case 0:
                            System.out.println("Thoat!");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, vui long nhap lai!");
                            break;
                    }
                } while (lc != 0);
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay phieu nhap");
        }
    }

    public void ghiFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/DanhSachPhieuNhap.txt"));
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            for (int i = 0; i < soptu; i++) {
                PhieuNhap pn = dspn[i];
                bw.write(pn.getMaPN() + "," + pn.getNgayLap().format(f) + "," + pn.getTongTien() + ","
                        + pn.getNhaCungCap().getMaNCC() + "," + pn.getNhanVien().getMaNV());
                bw.newLine();
            }
            bw.close();
            System.out.println("Ghi file thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void ThongKeTongDoanhThuTheoQuy() {
        double tong1 = 0;
        double tong2 = 0;
        double tong3 = 0;
        double tong4 = 0;
        for (int i = 0; i < soptu; i++) {
            int thang = dspn[i].getNgayLap().getMonthValue();
            double tongtien = dspn[i].getTongTien();
            if (thang >= 1 && thang <= 3)
                tong1 += tongtien;
            else if (thang >= 4 && thang <= 6)
                tong2 += tongtien;
            else if (thang >= 7 && thang <= 9)
                tong3 += tongtien;
            else if (thang >= 10 && thang <= 12)
                tong4 += tongtien;
        }
        System.out.println("Tổng doanh thu Quý 1: " + tong1);
        System.out.println("Tổng doanh thu Quý 2: " + tong2);
        System.out.println("Tổng doanh thu Quý 3: " + tong3);
        System.out.println("Tổng doanh thu Quý 4: " + tong4);
    }

    public void ThongKePnTheoNCC(String mancc) {
        int dem = 0;
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getNhaCungCap().getMaNCC().equalsIgnoreCase(mancc)) {
                dem++;
            }
        }
        System.out.println("Nha cung cap co ma " + mancc + " co so luong phieu nhap la: " + dem);
    }

    public void ThongKeTheoNCC() {
        String[] maNCCs = new String[soptu];
        int[] soPhieu = new int[soptu];
        double[] tongTien = new double[soptu];
        int dem = 0;

        for (int i = 0; i < soptu; i++) {
            String maNCC = dspn[i].getNhaCungCap().getMaNCC();
            double tien = dspn[i].getTongTien();

            int vitri = -1;
            for (int j = 0; j < dem; j++) {
                if (maNCCs[j].equals(maNCC)) {
                    vitri = j;
                    break;
                }
            }

            if (vitri == -1) {
                maNCCs[dem] = maNCC;
                soPhieu[dem] = 1;
                tongTien[dem] = tien;
                dem++;
            } else {
                soPhieu[vitri]++;
                tongTien[vitri] += tien;
            }
        }

        System.out.printf("%-10s %-15s %-15s%n", "Mã NCC", "Số Phiếu", "Tổng Tiền");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-10s %-15d %-15.2f%n", maNCCs[i], soPhieu[i], tongTien[i]);
        }
    }

    public boolean KtraMaPn(String mapn) {
        for (int i = 0; i < soptu; i++) {
            if (mapn.equals(dspn[i].getMaPN())) {
                return true;
            }
        }
        return false;
    }

    public PhieuNhap layPhieuNhap(String maPN) {
        for (int i = 0; i < soptu; i++) {
            if (dspn[i].getMaPN().equalsIgnoreCase(maPN)) {
                return dspn[i];
            }
        }
        return null;
    }
}
