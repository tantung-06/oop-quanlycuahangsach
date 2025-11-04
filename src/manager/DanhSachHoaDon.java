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

import src.model.hoadon.HoaDon;

public class DanhSachHoaDon {
    private HoaDon[] dshd;
    private int soLuongHoaDon;
    private DanhSachSach dssach;
    private DanhSachChiTietHoaDon dscthd;

    HoaDon hd = new HoaDon();

    public DanhSachHoaDon(DanhSachSach dss, DanhSachChiTietHoaDon dsct) {
        this.dshd = new HoaDon[0];
        this.soLuongHoaDon = 0;
        this.dssach = dss;
        this.dscthd = dsct;
    }

    public DanhSachHoaDon() {
        dshd = new HoaDon[0];
        soLuongHoaDon = 0;
    }

    public DanhSachHoaDon(HoaDon[] dshd) {
        this.dshd = dshd;
    }

    public DanhSachHoaDon(DanhSachHoaDon hd) {
        this.dshd = hd.dshd;
    }

    public HoaDon[] getHoaDon() {
        return dshd;
    }

    public void setDSHD(HoaDon[] dshd) {
        this.dshd = dshd;
    }

    public void themHoaDon() {
        Scanner sc = new Scanner(System.in);
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[soLuongHoaDon] = new HoaDon();
        dshd[soLuongHoaDon].nhap();
        while (!dscthd.kiemTraMaHoaDon(dshd[soLuongHoaDon].getMaHoaDon())) {
            System.out.print("Khong co ma hoa don nay trong chi tiet hoa don! Vui long nhap lai: ");
            String maHoaDon = sc.nextLine();
            dshd[soLuongHoaDon].setMaHoaDon(maHoaDon);
        }
        while (dshd[soLuongHoaDon].getTienKhachDua() < dscthd.tongTien(dshd[soLuongHoaDon].getMaHoaDon())) {
            System.out.print("So tien khong du de thanh toan! Vui long nhap lai:");
            double tienKhachHangDua = sc.nextDouble();
            dshd[soLuongHoaDon].setTienKhachDua(tienKhachHangDua);
            double tienThua = tienKhachHangDua - dscthd.tongTien(dshd[soLuongHoaDon].getMaHoaDon());
            dshd[soLuongHoaDon].setTienThua(tienThua);
        }
        soLuongHoaDon++;
    }

    public void hienThiHoaDon() {
        if (soLuongHoaDon == 0)
            System.out.println("Khong co hoa don nao trong danh sach!");
        else
            System.out.println("DANH SACH HOA DON:");
        for (int i = 0; i < soLuongHoaDon; i++) {
            dshd[i].xuat();
            dscthd.hienThiTheoMaHD(dshd[i].getMaHoaDon());
        }
    }

    public HoaDon timHoaDonTheoMa(String maHoaDon) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                dshd[i].xuat();
                return dshd[i];
            }
        }
        System.out.println("Khong tim thay hoa don tren!");
        return null;
    }

    public void hienThiHoaDonTheoMaHD(String maHoaDon) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                System.out.println("Ma Hoa Don:" + dshd[i].getMaHoaDon());
                System.out.println("Ngay Lap:" + dshd[i].getNgayLap());
                dscthd.hienThiTheoMaHD(dshd[i].getMaHoaDon());
                System.out.println("Tong Tien:" + dshd[i].getTongTien());
                System.out.println("Tien Khach Hang Dua:" + dshd[i].getTienKhachDua());
                System.out.println("Tien Thua:" + dshd[i].getTienThua());
            }
        }
    }

    public void xoaHoaDon(String maHoaDon) {
        int vitri = -1;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                vitri = i;
            }
        }
        if (vitri != -1) {
            for (int j = vitri; j < soLuongHoaDon - 1; j++) {
                dshd[j] = dshd[j + 1];
            }
            soLuongHoaDon--;
            dshd = Arrays.copyOf(dshd, dshd.length - 1);
            System.out.println("Da xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay hoa don can xoa!");
        }
    }

    public void suaThongTinHoaDon(String maHoaDon) {
        int luachon;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                do {
                    System.out.println("""
                            1.SUA MA KHACH HANG.
                            2.SUA MA NHAN VIEN.
                            3.SUA SO TIEN KHACH HANG DUA.
                            0.THOAT.
                            NHAP LUA CHON CUA BAN:
                            """);
                    luachon = sc.nextInt();
                    sc.nextLine();
                    switch (luachon) {
                        case 1:
                            System.out.print("Nhap ma khach hang ma ban muon sua:");
                            String maKH = sc.nextLine();
                            dshd[i].setMaKhachHang(maKH);
                            break;
                        case 2:
                            System.out.print("Nhap ma nhan vien ma ban muon sua:");
                            String maNV = sc.nextLine();
                            dshd[i].setMaNhanVien(maNV);
                            break;
                        case 3:
                            System.out.print("Nhap so tien khach hang dua:");
                            double soTien = sc.nextDouble();
                            while (soTien < dscthd.tongTien(maHoaDon)) {
                                System.out.print("So tien khong du de thanh toan! Vui long nhap lai:");
                                soTien = sc.nextDouble();
                            }
                            dshd[i].setTienKhachDua(soTien);
                            double tienThua = soTien - dscthd.tongTien(maHoaDon);
                            dshd[i].setTienThua(tienThua);
                            break;
                        default:
                            System.out.print("Lua chon khong hop le! Vui long nhap lai:");
                    }
                } while (luachon != 0);
            }
        }
    }

    public void docFile() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachHoaDon.txt"))) {
            String line;
            soLuongHoaDon = 0;
            dshd = new HoaDon[0];
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue;

                String[] parts = line.split(",\\s*");
                if (parts.length < 7) {
                    System.out.println("Dong sai dinh dang: " + line);
                    continue;
                }

                String maHD = parts[0];
                LocalDate ngayLap = LocalDate.parse(parts[1], f);
                double tongTien = Double.parseDouble(parts[2]);
                String maKH = parts[3];
                String maNV = parts[4];
                double tienKhachHangDua = Double.parseDouble(parts[5]);
                double tienThua = Double.parseDouble(parts[6]);

                dshd[soLuongHoaDon] = new HoaDon(maHD, ngayLap, tongTien, maKH, maNV, tienKhachHangDua, tienThua);
                dshd = Arrays.copyOf(dshd, dshd.length + 1);
                soLuongHoaDon++;
            }
            System.out.println("Doc file thanh cong! Co  " + soLuongHoaDon + " hoa don.");
        } catch (IOException e) {
            System.out.println("Loi doc file!: " + e.getMessage());
        }
    }

    public void ghiFile() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/DanhSachHoaDon.txt"))) {
            for (int i = 0; i < soLuongHoaDon; i++) {
                HoaDon hd = dshd[i];
                bw.write(hd.getMaHoaDon() + ", "
                        + hd.getNgayLap().format(f) + ", "
                        + hd.getTongTien() + ", "
                        + hd.getMaKhachHang() + ", "
                        + hd.getMaNhanVien() + ", "
                        + hd.getTienKhachDua() + ", "
                        + hd.getTienThua());
                bw.newLine();
            }
            System.out.println("ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public double tongDoanhThuNgay(int ngay, int thang, int nam) {
        double tongDoanhThu = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getNgayLap().getDayOfMonth() == ngay && dshd[i].getNgayLap().getMonthValue() == thang
                    && dshd[i].getNgayLap().getYear() == nam) {
                tongDoanhThu += dshd[i].getTongTien();
            }
        }
        return tongDoanhThu;
    }

    public double tongDanhThuTheoThang(int thang, int nam) {
        double tongDoanhThu = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getNgayLap().getMonthValue() == thang && dshd[i].getNgayLap().getYear() == nam) {
                tongDoanhThu += dshd[i].getTongTien();
            }
        }
        return tongDoanhThu;
    }

    public double tongDoanhThuTheoNam(int nam) {
        double tongDoanhThu = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getNgayLap().getYear() == nam) {
                tongDoanhThu += dshd[i].getTongTien();
            }
        }
        return tongDoanhThu;
    }

    public void tongSoLuongHDMaNhanVienBan() {
        int dem = 0;
        int[] sl = new int[soLuongHoaDon];
        String[] NV = new String[soLuongHoaDon];
        for (int i = 0; i < soLuongHoaDon; i++) {
            String maNV = dshd[i].getMaNhanVien();
            boolean tontai = false;
            for (int j = 0; j < dem; j++) {
                if (NV[j].equalsIgnoreCase(maNV)) {
                    sl[j]++;
                    tontai = true;
                }
            }
            if (!tontai) {
                NV[dem] = maNV;
                sl[dem] = 1;
                dem++;
            }
        }
        System.out.printf("%-12s |%-16s%n", "Ma nhan vien", "So luong hoa don");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-12s |%-16d%n", NV[i], sl[i]);
        }
    }

    public void hienThiHoaDonTheoNgay(int ngay, int thang, int nam) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getNgayLap().getDayOfMonth() == ngay && dshd[i].getNgayLap().getMonthValue() == thang
                    && dshd[i].getNgayLap().getYear() == nam) {
                hienThiHoaDonTheoMaHD(dshd[i].getMaHoaDon());
            }
        }
    }

    public void hienThiHoaDonTheoThang(int thang, int nam) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getNgayLap().getMonthValue() == thang && dshd[i].getNgayLap().getYear() == nam) {
                hienThiHoaDonTheoMaHD(dshd[i].getMaHoaDon());
            }
        }
    }

    public void hienThiHoaDonTheoNam(int nam) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getNgayLap().getYear() == nam) {
                hienThiHoaDonTheoMaHD(dshd[i].getMaHoaDon());
            }
        }
    }

    public void hienThiHoaDonTheoMaNV(String maNhanVien) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                hienThiHoaDonTheoMaHD(dshd[i].getMaHoaDon());
            }
        }
    }

    public void hienThiHoaDonTheoMaKH(String maKhachHang) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
                System.out.println("Hoa Don:" + dshd[i].getMaHoaDon());
                System.out.println("Ngay Lap:" + dshd[i].getNgayLap());
                dscthd.hienThiTheoMaHD(dshd[i].getMaHoaDon());
                System.out.println("Tong Tien:" + dshd[i].getTongTien());
                System.out.println("Tien Khach Hang Dua:" + dshd[i].getTienKhachDua());
                System.out.println("Tien Thua:" + dshd[i].getTienThua());
            }
        }
    }

    public double tongSoTienKhachHangMua(String maKhachHang) {
        double tong = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (dshd[i].getMaKhachHang().equalsIgnoreCase(maKhachHang)) {
                tong += dshd[i].getTongTien();
            }
        }
        return tong;
    }

    public void thongKeSoTienKhachHangMua() {
        int dem = 0;
        String[] KH = new String[soLuongHoaDon];
        double[] ST = new double[soLuongHoaDon];
        for (int i = 0; i < soLuongHoaDon; i++) {
            boolean tontai = false;
            String maKH = dshd[i].getMaKhachHang();
            double tongTien = dshd[i].getTongTien();
            for (int j = 0; j < dem; j++) {
                if (KH[j].equalsIgnoreCase(maKH)) {
                    ST[j] += tongTien;
                    tontai = true;
                }
            }
            if (!tontai) {
                KH[dem] = maKH;
                ST[dem] = tongTien;
                dem++;
            }
        }
        System.out.printf("%-13s | %-19s%n", "Ma khach hang", "Tong so tien da mua");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-13s | %-19s%n", KH[i], ST[i]);
        }
    }
}
