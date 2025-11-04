package src.manager;

import src.model.sach.Sach;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import src.model.phieunhap.ChiTietPhieuNhap;
import src.model.phieunhap.PhieuNhap;
import java.util.Arrays;

public class DanhSachChiTietPhieuNhap {
    private int soptu;
    private ChiTietPhieuNhap[] dschitiet;
    private DanhSachPhieuNhap dspn;
    private DanhSachSach ddsach;

    public DanhSachChiTietPhieuNhap() {
        soptu = 0;
        dschitiet = new ChiTietPhieuNhap[0];
        dspn = new DanhSachPhieuNhap();
        ddsach = new DanhSachSach();
    }

    public void docfile() {
        try {
            dspn.docfile();
            ddsach.docFile();

            BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachChiTietPhieuNhap.txt"));
            String line;
            soptu = 0;
            dschitiet = new ChiTietPhieuNhap[0];

            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                if (part.length == 4) {
                    String mapn = part[0].trim();
                    String masach = part[1].trim();
                    int soluong = Integer.parseInt(part[2].trim());
                    double dongia = Double.parseDouble(part[3].trim());

                    PhieuNhap pn = dspn.layPhieuNhap(mapn);
                    Sach sach = ddsach.laySach(masach);

                    if (pn != null && sach != null) {
                        ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(pn, sach, soluong, dongia);
                        dschitiet = Arrays.copyOf(dschitiet, dschitiet.length + 1);
                        dschitiet[soptu++] = ctpn;
                    }
                }
            }
            br.close();
            System.out.println("Doc file DanhSachChiTietPhieuNhap thanh cong");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghifile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/DanhSachChiTietPhieuNhap.txt"));
            for (int i = 0; i < soptu; i++) {
                ChiTietPhieuNhap ct = dschitiet[i];
                bw.write(ct.getPhieuNhap().getMaPN() + ", " +
                        ct.getSach().getMaSach() + ", " +
                        ct.getSoLuong() + ", " +
                        ct.getDonGia());
                bw.newLine();
            }
            bw.close();
            System.out.println("Ghi file DanhSachChiTietPhieuNhap thanh cong");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void ThemChiTietPn(DanhSachPhieuNhap dspn, DanhSachSach dssach) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma phieu nhap: ");
        String mapn = sc.nextLine();
        PhieuNhap pn = dspn.layPhieuNhap(mapn);

        while (pn == null) {
            System.out.println("Khong tim thay ma phieu nhap, vui long nhap lai!");
            System.out.print("Nhap ma phieu nhap: ");
            mapn = sc.nextLine();
            pn = dspn.layPhieuNhap(mapn);
        }

        System.out.print("Nhap ma sach: ");
        String maS = sc.nextLine();
        Sach sach = dssach.laySach(maS);

        while (sach == null) {
            System.out.println("Khong tim thay ma sach do, vui long nhap lai!");
            System.out.print("Nhap ma sach: ");
            maS = sc.nextLine();
            sach = dssach.laySach(maS);
        }

        // Tạo chi tiết phiếu nhập mới
        ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
        ctpn.nhap(pn, sach);

        // Thêm vào mảng
        dschitiet = Arrays.copyOf(dschitiet, soptu + 1);
        dschitiet[soptu] = ctpn;
        soptu++;

        System.out.println("Them chi tiet phieu nhap thanh cong!");
    }

    public void XoaDsCtPn(String mapn, String maS) {
        boolean tim = false;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getPhieuNhap().getMaPN().equalsIgnoreCase(mapn)
                    && dschitiet[i].getSach().getMaSach().equalsIgnoreCase(maS)) {
                for (int j = i; j < soptu - 1; j++) {
                    dschitiet[j] = dschitiet[j + 1];
                }
                soptu--;
                dschitiet = Arrays.copyOf(dschitiet, soptu);
                tim = true;
                System.out.println("Da xoa chi tiet phieu nhap co ma phieu nhap " + mapn + " va ma sach " + maS);
                break;
            }
        }
        if (!tim) {
            System.out.println("Khong tim thay chi tiet phieu nhap can xoa");
        }
    }

    public ChiTietPhieuNhap TimKiemCtPnTheoMa(String mapn, String maS) {
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getPhieuNhap().getMaPN().equalsIgnoreCase(mapn)
                    && dschitiet[i].getSach().getMaSach().equalsIgnoreCase(maS)) {
                dschitiet[i].xuat();
                return dschitiet[i];
            }
        }
        System.out.println("Khong tim thay chi tiet phieu nhap!");
        return null;
    }

    public ChiTietPhieuNhap[] TimKiemCtPnTheoSL(int soluong) {
        int dem = 0;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getSoLuong() == soluong) {
                dschitiet[i].xuat();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("khong co chi tiet phieu nhap nao co so luong nhu tren");
        }
        ChiTietPhieuNhap[] kq = new ChiTietPhieuNhap[dem];
        int a = 0;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getSoLuong() == soluong) {
                kq[a++] = dschitiet[i];
            }
        }
        return kq;
    }

    public ChiTietPhieuNhap[] TimKiemCtPnTheoDonGia(double dongia) {
        int dem = 0;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getDonGia() == dongia) {
                dschitiet[i].xuat();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("khong co chi tiet phieu nhap nao co don gia nhu tren");
        }
        ChiTietPhieuNhap[] kq = new ChiTietPhieuNhap[dem];
        int a = 0;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getDonGia() == dongia) {
                kq[a++] = dschitiet[i];
            }
        }
        return kq;
    }

    public void SuaCtPn(String mapn, String maS, DanhSachPhieuNhap dspn, DanhSachSach dssach) {
        Scanner sc = new Scanner(System.in);
        boolean tim = false;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getPhieuNhap().getMaPN().equalsIgnoreCase(mapn)
                    && dschitiet[i].getSach().getMaSach().equalsIgnoreCase(maS)) {
                tim = true;
                int chon;

                do {
                    System.out.println("===== SUA CHI TIET PHIEU NHAP =====");
                    System.out.println("1. Sua so luong");
                    System.out.println("2. Sua don gia");
                    System.out.println("3. Sua ma phieu nhap");
                    System.out.println("4. Sua ma sach");
                    System.out.println("0. thoat");
                    System.out.println("Vui long chon: ");
                    chon = sc.nextInt();
                    sc.nextLine();

                    switch (chon) {
                        case 1:
                            System.out.println("Nhap so luong moi: ");
                            dschitiet[i].setSoLuong(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 2:
                            System.out.println("Nhap don gia moi: ");
                            dschitiet[i].setDonGia(sc.nextDouble());
                            sc.nextLine();
                            break;
                        case 3:
                            System.out.print("Nhap ma phieu nhap moi: ");
                            String mapnMoi = sc.nextLine();
                            PhieuNhap pnMoi = dspn.layPhieuNhap(mapnMoi);

                            if (pnMoi != null) {
                                dschitiet[i].setPhieuNhap(pnMoi);
                                System.out.println("Cap nhat ma phieu nhap thanh cong!");
                            } else {
                                System.out.println("Ma phieu nhap moi khong ton tai!");
                            }
                            break;
                        case 4:
                            System.out.print("Nhap ma sach moi: ");
                            String maSMoi = sc.nextLine();
                            Sach sachMoi = dssach.laySach(maSMoi);

                            if (sachMoi != null) {
                                dschitiet[i].setSach(sachMoi);
                                System.out.println("Cap nhat ma sach thanh cong!");
                            } else {
                                System.out.println("Ma sach moi khong ton tai!");
                            }
                            break;
                        case 0:
                            System.out.println("Thoat!");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le, vui long nhap lai!");
                            break;
                    }
                } while (chon != 0);

            }
        }
        if (!tim) {
            System.out.println("Khong tim thay chi tiet phieu nhap de sua");
        }
    }

    public int ThongKeSLSachDaNhap() {
        int tong = 0;
        for (int i = 0; i < soptu; i++) {
            tong += dschitiet[i].getSoLuong();
        }
        System.out.println("Tong so luong sach da nhap la: ");
        return tong;
    }

    public int ThongKeTheoMaSach(String maS) {
        int tongSL = 0;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getSach().getMaSach().equalsIgnoreCase(maS)) {
                tongSL += dschitiet[i].getSoLuong();
            }
        }
        System.out.println("Ma sach " + maS + " co tong so luong: " + tongSL);
        return tongSL;
    }

    public int ThongKeTheoMaPN(String maPN) {
        int tongSL = 0;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getPhieuNhap().getMaPN().equalsIgnoreCase(maPN)) {
                tongSL += dschitiet[i].getSoLuong();
            }
        }
        System.out.println("Ma sach " + maPN + " co tong so luong: " + tongSL);
        return tongSL;
    }

    public void xuatDsCtPn() {
        if (soptu == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("===== DANH SACH CHI TIET PHIEU NHAP =====");
        System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-15s |\n", "Ma PN", "Ma Sach", "So Luong", "Don Gia",
                "Thanh Tien");
        for (int i = 0; i < soptu; i++) {
            dschitiet[i].xuat();
        }
    }

    public double tinhTongTienTheoMaPN(String maPN) {
        double tong = 0;
        for (int i = 0; i < soptu; i++) {
            if (dschitiet[i].getPhieuNhap().getMaPN().equalsIgnoreCase(maPN)) {
                tong += dschitiet[i].getThanhTien();
            }
        }
        return tong;
    }
}