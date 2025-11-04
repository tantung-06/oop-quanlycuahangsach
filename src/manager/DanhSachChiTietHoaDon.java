package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import src.model.hoadon.ChiTietHoaDon;

public class DanhSachChiTietHoaDon {
    private ChiTietHoaDon[] dscthd;
    private int soLuongDSCTHD;
    ChiTietHoaDon ctdh = new ChiTietHoaDon();
    private DanhSachSach dssach;

    public DanhSachChiTietHoaDon(DanhSachSach dss) {
        this.dscthd = new ChiTietHoaDon[0];
        this.soLuongDSCTHD = 0;
        this.dssach = dss;
    }

    public DanhSachChiTietHoaDon() {
        dscthd = new ChiTietHoaDon[0];
        soLuongDSCTHD = 0;
    }

    public DanhSachChiTietHoaDon(ChiTietHoaDon[] dscthd) {
        this.dscthd = dscthd;
    }

    public DanhSachChiTietHoaDon(DanhSachChiTietHoaDon ds) {
        this.dscthd = ds.dscthd;
    }

    public ChiTietHoaDon[] getDSCTDH() {
        return dscthd;
    }

    public void setDSCTHD(ChiTietHoaDon[] dscthd) {
        this.dscthd = dscthd;
    }

    public void nhapHoaDon() {
        Scanner sc = new Scanner(System.in);
        dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
        String maHoaDonLanDau = null;
        boolean lanDau = true;
        while (true) {
            System.out.print("Muon nhap tiep san pham(y/n):");
            String chon = sc.nextLine();
            if (chon.equalsIgnoreCase("n"))
                break;
            dscthd[soLuongDSCTHD] = new ChiTietHoaDon();
            dscthd[soLuongDSCTHD].nhap();
            String maHD = dscthd[soLuongDSCTHD].getMaHoaDon();
            if (lanDau) {
                while (kiemTraMaHoaDon(maHD)) {
                    System.out.println("Ma hoa don nay da bi trung! Vui long nhap lai:");
                    maHD = sc.nextLine();
                    dscthd[soLuongDSCTHD].setMaHoaDon(maHD);
                }
                maHoaDonLanDau = maHD;
                lanDau = false;
            }
            if (!lanDau) {
                while (!maHD.equalsIgnoreCase(maHoaDonLanDau)) {
                    System.out.print("Ma don nay khong trung voi ma ban vua nhap! Vui long nhap lai:");
                    maHD = sc.nextLine();
                    dscthd[soLuongDSCTHD].setMaHoaDon(maHD);
                }
            }
            dscthd[soLuongDSCTHD].setDonGia(dssach.layDonGiaTheoMa(dscthd[soLuongDSCTHD].getMaSach()));
            dscthd[soLuongDSCTHD].setThanhTien(dscthd[soLuongDSCTHD].getDonGia(), dscthd[soLuongDSCTHD].getSoLuong());
            while (!dssach.kiemTraMaSach(dscthd[soLuongDSCTHD].getMaSach())) {
                System.out.print("Ma sach khong ton tai! Vui long nhap lai ma sach:");
                String maSach = sc.nextLine();
                dscthd[soLuongDSCTHD].setMaSach(maSach);
            }
            while (!dssach.kiemTraSoLuongSach(dscthd[soLuongDSCTHD].getMaSach(), dscthd[soLuongDSCTHD].getSoLuong())) {
                System.out.print("So luong mua lon hon so luong hien co cua sach! Vui long nhap lai so luong:");
                int soLuong = sc.nextInt();
                dscthd[soLuongDSCTHD].setSoLuong(soLuong);
            }
            dscthd[soLuongDSCTHD].setDonGia(dssach.layDonGiaTheoMa(dscthd[soLuongDSCTHD].getMaSach()));
            dssach.giamSoLuongSach(dscthd[soLuongDSCTHD].getMaSach(), dscthd[soLuongDSCTHD].getSoLuong());
            soLuongDSCTHD++;
            dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
        }
    }

    public void xuat() {
        for (int i = 0; i < soLuongDSCTHD; i++) {
            dscthd[i].xuat();
        }
    }

    public double tongTien(String maDonHang) {
        double tongtien = 0;
        for (int i = 0; i < soLuongDSCTHD; i++) {
            if (dscthd[i].getMaHoaDon().equalsIgnoreCase(maDonHang))
                tongtien += dscthd[i].getThanhTien();
        }
        return tongtien;
    }

    public ChiTietHoaDon hienThiTheoMaHD(String maHoaDon) {
        ChiTietHoaDon kq = null;
        for (int i = 0; i < soLuongDSCTHD; i++) {
            if (dscthd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                kq = dscthd[i];
                kq.xuat();
            }
        }
        return kq;
    }

    public boolean kiemTraMaHoaDon(String maHoaDon) {
        for (int i = 0; i < soLuongDSCTHD; i++) {
            if (dscthd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon))
                return true;
        }
        return false;
    }

    public void xoaChiTietHoaDon(String maHoaDon, String maSach) {
        int vitri = -1;
        for (int i = 0; i < 0; i++) {
            if (dscthd[i].getMaSach().equalsIgnoreCase(maSach) && dscthd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                vitri = i;
            }
        }
        if (vitri != -1) {
            for (int j = vitri; j < soLuongDSCTHD - 1; j++) {
                dscthd[j] = dscthd[j++];
            }
            dscthd = Arrays.copyOf(dscthd, dscthd.length - 1);
        } else
            System.out.println("Khong co chi tiet hoa don nay!");
    }

    // vi danh sach chi hoa don dc luu theo 1 day ds co cung ma hoa don lien ke nen
    // dung ham nay cho de
    public void XoaChiTietHoaDonTheoMa(String maHoaDon) {
        int vitridau = -1;
        int vitricuoi = -1;
        for (int i = 0; i < soLuongDSCTHD; i++) {
            if (dscthd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                vitridau = i;
                vitricuoi = i;
                break;
            }
        }
        if (vitridau == -1) {
            System.out.println("Khong tim thay ma hoa don!");
            return;
        }
        for (int j = vitridau + 1; j < soLuongDSCTHD; j++) {
            if (dscthd[j].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                vitricuoi = j;
            } else
                break;
        }
        for (int k = vitridau; k < soLuongDSCTHD - (vitricuoi - vitridau + 1); k++) {
            dscthd[k] = dscthd[k + vitricuoi - vitridau + 1];
        }
        dscthd = Arrays.copyOf(dscthd, dscthd.length - (vitricuoi - vitridau + 1));
    }

    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/DanhSachChiTietHoaDon.txt"))) {
            for (int i = 0; i < soLuongDSCTHD; i++) {
                ChiTietHoaDon cthd = dscthd[i];
                bw.write(cthd.getMaHoaDon() + ", " +
                        cthd.getMaSach() + ", " +
                        cthd.getSoLuong() + ", " +
                        cthd.getDonGia());
                bw.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachChiTietHoaDon.txt"))) {
            String line;
            soLuongDSCTHD = 0;
            dscthd = new ChiTietHoaDon[soLuongDSCTHD + 1];
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                    continue; // bo dong tron
                String[] parts = line.split(",");

                if (parts.length < 4) {
                    System.out.println("Dong du lieu sai dinh dang: " + line);
                    continue;
                }

                String maHD = parts[0].trim();
                String maSach = parts[1].trim();
                int soLuongSach = Integer.parseInt(parts[2].trim());
                double donGia = Double.parseDouble(parts[3].trim());
                double thanhTien = Double.parseDouble(parts[4].trim());

                dscthd[soLuongDSCTHD] = new ChiTietHoaDon(maHD, maSach, soLuongSach, donGia, thanhTien);
                dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
                soLuongDSCTHD++;
            }

            System.out.println("Doc file thanh cong! Co " + soLuongDSCTHD + " chi tiết hóa đơn.");
        } catch (FileNotFoundException e) {
            System.out.println(" File chưa ton tai!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void suaThongTinChiTietHoaDon(String maHoaDon) {
        Scanner sc = new Scanner(System.in);
        int luachon;
        int soLuong = 0;
        int soLuongThayDoi;
        String maSach;
        String maSachMoi;
        for (int i = 0; i < soLuongDSCTHD; i++) {
            if (dscthd[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                do {
                    System.out.println("""
                            1.SUA MA SACH.
                            2.SUA SO LUONG MUA.
                            0.THOAT!
                            NHAP LUA CHON CUA BAN:
                            """);
                    luachon = sc.nextInt();
                    sc.nextLine();
                    switch (luachon) {
                        case 1:
                            System.out.print("Nhap ma sach ma ban muon sua:");
                            maSach = sc.nextLine();
                            for (int j = 0; j < soLuongDSCTHD; j++) {
                                if (dscthd[j].getMaHoaDon().equalsIgnoreCase(maHoaDon)
                                        && dscthd[j].getMaSach().equalsIgnoreCase(maSach)) {
                                    System.out.print("Nhap ma sach moi ma ban muon sua:");
                                    maSachMoi = sc.nextLine();
                                    while (!dssach.kiemTraMaSach(maSachMoi)) {
                                        System.out.print("Khong co ma sach nay! Vui long nhap lai:");
                                        maSachMoi = sc.nextLine();
                                    }
                                    if (!dssach.kiemTraSoLuongSach(maSachMoi, dscthd[j].getSoLuong())) {
                                        System.out.print("So luong sach nay khong du! Vui long nhap lai:");
                                        soLuong = sc.nextInt();
                                        while (!dssach.kiemTraSoLuongSach(maSachMoi, soLuong)) {
                                            System.out.print(
                                                    "Sach nay khong du so luong! Vui long nhap lai so luong sach:");
                                            soLuong = sc.nextInt();
                                        }
                                    }
                                    dssach.tangSoLuongSach(dscthd[j].getMaSach(), dscthd[j].getSoLuong());
                                    dssach.giamSoLuongSach(maSachMoi, soLuong);
                                    dscthd[j].setMaSach(maSach);
                                    dscthd[j].setDonGia(dssach.layDonGiaTheoMa(dscthd[j].getMaSach()));
                                    dscthd[j].setThanhTien(dscthd[j].getDonGia(), soLuong);
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Nhap ma sach ma ban muon thay doi so luong:");
                            maSach = sc.nextLine();
                            for (int j = 0; j < soLuongDSCTHD; j++) {
                                if (dscthd[j].getMaHoaDon().equalsIgnoreCase(maHoaDon)
                                        && dscthd[j].getMaSach().equalsIgnoreCase(maSach)) {
                                    System.out.print("Nhap so luong ma ban muon thay doi:");
                                    soLuong = sc.nextInt();
                                    while (!dssach.kiemTraSoLuongSach(maSach, soLuong)) {
                                        System.out.print("So luong sach khong du! Vui long nhap lai:");
                                        soLuong = sc.nextInt();
                                    }
                                    if (dscthd[j].getSoLuong() > soLuong) {
                                        soLuongThayDoi = dscthd[j].getSoLuong() - soLuong;
                                        dssach.tangSoLuongSach(maSach, soLuongThayDoi);
                                        dscthd[j].setSoLuong(soLuong);
                                        dscthd[j].setThanhTien(dscthd[j].getDonGia(), soLuong);
                                    } else {
                                        soLuongThayDoi = soLuong - dscthd[j].getSoLuong();
                                        dssach.giamSoLuongSach(maSach, soLuongThayDoi);
                                        dscthd[j].setSoLuong(soLuong);
                                        dscthd[j].setThanhTien(dscthd[j].getDonGia(), soLuong);
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.print("Lua chon khong hop le! Vui long nhap lai:");
                    }
                } while (luachon != 0);
            }
        }
    }

    public void thongKeSLSachBanGiamDan() {
        int[] slsb = new int[soLuongDSCTHD];
        String[] maSach = new String[soLuongDSCTHD];
        int dem = 0;
        for (int i = 0; i < soLuongDSCTHD; i++) {
            String ma = dscthd[i].getMaSach();
            int sl = dscthd[i].getSoLuong();
            boolean tontai = false;
            for (int j = 0; j < dem; j++) {
                if (maSach[j].equalsIgnoreCase(ma)) {
                    tontai = true;
                    slsb[j] += sl;
                    break;
                }
            }
            if (!tontai) {
                maSach[dem] = ma;
                slsb[dem] = sl;
                dem++;
            }
        }
        for (int i = 0; i < soLuongDSCTHD - 1; i++) {
            for (int j = i + 1; j < soLuongDSCTHD; j++) {
                if (slsb[i] < slsb[j]) {
                    int tamsl = slsb[i];
                    slsb[i] = slsb[j];
                    slsb[j] = tamsl;
                    String tamma = maSach[i];
                    maSach[i] = maSach[j];
                    maSach[j] = tamma;
                }
            }
        }
        System.out.printf("%-10s | %-15s%n", "Ma sach", "Tong so luong ban");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-10s | %-15d%n", maSach[i], slsb[i]);
        }
    }

    public ChiTietHoaDon hienThiChiTietHoaDonTheoMaSach(String maSach) {
        ChiTietHoaDon cthd = null;
        for (int i = 0; i < soLuongDSCTHD; i++) {
            if (dscthd[i].getMaSach().equalsIgnoreCase(maSach)) {
                cthd = dscthd[i];
                cthd.xuat();
            }
        }
        if (cthd == null)
            System.out.print("Khong co ma sach nay trong chi tiet hoa don!");
        return cthd;
    }
}