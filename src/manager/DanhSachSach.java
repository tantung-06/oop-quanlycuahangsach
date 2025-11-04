package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import src.model.sach.NhaXuatBan;
import src.model.sach.Sach;
import src.model.sach.SachGiaoKhoa;
import src.model.sach.SachThamKhao;
import src.model.sach.TacGia;

public class DanhSachSach {
    private int n;
    private Sach[] dss;
    private DanhSachTacGia dstg;
    private DanhSachNhaXuatBan dsnxb;

    public DanhSachSach() {
        n = 0;
        dss = new Sach[0];
        dstg = new DanhSachTacGia();
        dsnxb = new DanhSachNhaXuatBan();
    }

    // kiểm tra mã trùng nhau
    public boolean kiemTraMaSach(String maSach) {
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                return true;
            }
        }
        return false;
    }

    // nhập
    public void nhapSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach: ");
        n = sc.nextInt();
        sc.nextLine();

        dss = new Sach[n];

        for (int i = 0; i < n; i++) {
            System.out.println("----- Nhap thong tin sach thu " + (i + 1) + " -----");
            int lc;

            do {
                System.out.print("Lua chon nhap (1. Sach giao khoa / 2. Sach tham khao): ");
                lc = sc.nextInt();
                sc.nextLine();

                if (lc != 1 && lc != 2) {
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                }
            } while (lc != 1 && lc != 2);

            if (lc == 1) {
                dss[i] = new SachGiaoKhoa();
            } else {
                dss[i] = new SachThamKhao();
            }

            String maSach;
            do {
                System.out.print("Nhap ma sach: ");
                maSach = sc.nextLine();
                if (kiemTraMaSach(maSach)) {
                    System.out.println("Ma sach da ton tai, vui long nhap lai!");
                }
            } while (kiemTraMaSach(maSach));

            dss[i].setMaSach(maSach);

            dss[i].nhapKhongMa(dstg, dsnxb);
        }
    }

    // xuất
    public void xuatSach() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        System.out.println("========== DANH SACH SACH ==========");
        System.out.printf(
                "| %-10s | %-20s | %-10s | %-12s | %-14s | %-10s | %-10s | %-15s | %-5s | %-10s | %-12s | %-12s |\n",
                "Ma sach", "Ten sach", "The loai", "Nam xuat ban", "Don gia ban", "So luong", "Ma tac gia",
                "Ma nha xuat ban", "Lop", "Mon hoc", "Linh vuc", "Trinh do");
        for (int i = 0; i < n; i++) {
            dss[i].xuat();
        }
        System.out.println("====================================");
    }

    // thêm
    public void themSach() {
        Scanner sc = new Scanner(System.in);
        int lc;

        do {
            System.out.print("Lua chon nhap (1. Sach giao khoa / 2. Sach tham khao): ");
            lc = sc.nextInt();
            sc.nextLine();

            if (lc != 1 && lc != 2) {
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (lc != 1 && lc != 2);

        Sach s;
        if (lc == 1) {
            s = new SachGiaoKhoa();
        } else {
            s = new SachThamKhao();
        }

        String maSach;
        do {
            System.out.print("Nhap ma sach: ");
            maSach = sc.nextLine();
            if (kiemTraMaSach(maSach)) {
                System.out.println("Ma sach da ton tai, vui long nhap lai!");
            }
        } while (kiemTraMaSach(maSach));
        s.setMaSach(maSach);
        s.nhapKhongMa(dstg, dsnxb);

        dss = Arrays.copyOf(dss, n + 1);
        dss[n] = s;
        n++;
    }

    // xóa theo mã
    public void xoaSachTheoMa() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach can xoa: ");
        String maSach = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma: " + maSach);
            return;
        }

        for (int i = viTri; i < n - 1; i++) {
            dss[i] = dss[i + 1];
        }

        n--;
        dss = Arrays.copyOf(dss, n);
    }

    // sửa thông tin sách tại 1 trường
    public void suaSachTaiTruong() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach can sua: ");
        String maSach = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma: " + maSach);
            return;
        }

        int lc;
        do {

            System.out.println("========== SUA THONG TIN SACH CO MA " + maSach + " ==========");
            System.out.println("1. Ten Sach \n2. The loai \n3. Nam xuat ban \n4. Don gia \n5. So luong");
            if (dss[viTri] instanceof SachGiaoKhoa) {
                System.out.println("6. Lop \n7. Mon hoc");
            } else if (dss[viTri] instanceof SachThamKhao) {
                System.out.println("6. Linh vuc \n7. Trinh do");
            }

            System.out.println("0. Thoat!");
            System.out.println("===================================================");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    System.out.print("Nhap ten sach moi: ");
                    dss[viTri].setTenSach(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap the loai moi: ");
                    dss[viTri].setTheLoai(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap nam xuat ban moi: ");
                    dss[viTri].setNamXuatBan(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("Nhap don gia moi: ");
                    dss[viTri].setDonGia(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.print("Nhap so luong moi: ");
                    dss[viTri].setSoLuong(sc.nextInt());
                    sc.nextLine();
                    break;
                case 6:
                    if (dss[viTri] instanceof SachGiaoKhoa) {
                        System.out.print("Nhap lop moi: ");
                        ((SachGiaoKhoa) dss[viTri]).setLop(sc.nextLine());
                    } else if (dss[viTri] instanceof SachThamKhao) {
                        System.out.print("Nhap linh vuc moi: ");
                        ((SachThamKhao) dss[viTri]).setLinhVuc(sc.nextLine());
                    }
                    break;
                case 7:
                    if (dss[viTri] instanceof SachGiaoKhoa) {
                        System.out.print("Nhap mon hoc moi: ");
                        ((SachGiaoKhoa) dss[viTri]).setMonHoc(sc.nextLine());
                    } else if (dss[viTri] instanceof SachThamKhao) {
                        System.out.print("Nhap trinh do moi: ");
                        ((SachThamKhao) dss[viTri]).setTrinhDo(sc.nextLine());
                    }
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

    // tìm kiếm sách theo mã
    public void timKiemSachTheoMa() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach can tim: ");
        String maSach = sc.nextLine();

        boolean timThay = false;

        System.out.printf(
                "| %-10s | %-20s | %-10s | %-12s | %-14s | %-10s | %-10s | %-15s | %-5s | %-10s | %-12s | %-12s |\n",
                "Ma sach", "Ten sach", "The loai", "Nam xuat ban", "Don gia ban", "So luong", "Ma tac gia",
                "Ma nha xuat ban", "Lop", "Mon hoc", "Linh vuc", "Trinh do");
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                dss[i].xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach co ma: " + maSach);
        }
    }

    // tìm kiếm sách theo tên
    public void timKiemSachTheoTen() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten sach can tim: ");
        String tenSach = sc.nextLine();

        boolean timThay = false;

        System.out.printf(
                "| %-10s | %-20s | %-10s | %-12s | %-14s | %-10s | %-10s | %-15s | %-5s | %-10s | %-12s | %-12s |\n",
                "Ma sach", "Ten sach", "The loai", "Nam xuat ban", "Don gia ban", "So luong", "Ma tac gia",
                "Ma nha xuat ban", "Lop", "Mon hoc", "Linh vuc", "Trinh do");
        for (int i = 0; i < n; i++) {
            if (dss[i].getTenSach().equalsIgnoreCase(tenSach)) {
                dss[i].xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach co ten: " + tenSach);
        }
    }

    // thống kê tổng sách giáo khoa và sách tham khảo
    public int[] thongKeTongSoSach() {
        int sgk = 0;
        int stk = 0;

        for (int i = 0; i < n; i++) {
            if (dss[i] instanceof SachGiaoKhoa) {
                sgk++;
            } else if (dss[i] instanceof SachThamKhao) {
                stk++;
            }
        }
        return new int[] { sgk, stk };
    }

    // thống kê số lượng sách tồn kho
    public int[] thongKeSoLuongSach() {
        int tong = 0;
        for (int i = 0; i < n; i++) {
            tong += dss[i].getSoLuong();
        }
        return new int[] { tong };
    }

    // đọc file
    public void docFile() {
        try {
            dstg.docFile();
            dsnxb.docFile();

            BufferedReader br = new BufferedReader(new FileReader("src/data/DanhSachSach.txt"));
            String line;

            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
            }
            br.close();

            dss = new Sach[count];
            n = 0;

            BufferedReader bri = new BufferedReader(new FileReader("src/data/DanhSachSach.txt"));

            while ((line = bri.readLine()) != null) {
                String data[] = line.split(",");

                if (data.length == 11) {
                    String loai = data[0].trim();
                    String maSach = data[1].trim();
                    String tenSach = data[2].trim();
                    String theLoai = data[3].trim();
                    int namXuatBan = Integer.parseInt(data[4].trim());
                    int donGia = Integer.parseInt(data[5].trim());
                    int soLuong = Integer.parseInt(data[6].trim());
                    String maTG = data[7].trim();
                    String maNXB = data[8].trim();
                    String thuocTinh1 = data[9].trim(); // lớp or lĩnh vực
                    String thuocTinh2 = data[10].trim(); // môn học or trình độ

                    TacGia tg = new TacGia();
                    tg.setMaTG(maTG);

                    NhaXuatBan nxb = new NhaXuatBan();
                    nxb.setMaNXB(maNXB);

                    if (loai.equalsIgnoreCase("Giao khoa")) {
                        dss[n] = new SachGiaoKhoa(maSach, tenSach, theLoai, namXuatBan, donGia, soLuong,
                                tg, nxb, thuocTinh1, thuocTinh2);
                    } else if (loai.equalsIgnoreCase("Tham khao")) {
                        dss[n] = new SachThamKhao(maSach, tenSach, theLoai, namXuatBan, donGia, soLuong,
                                tg, nxb, thuocTinh1, thuocTinh2);
                    }
                    n++;
                }
            }
            bri.close();
            System.out.println("Doc file Sach thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // ghi file
    public void ghiFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/DanhSachSach.txt"));

            for (int i = 0; i < n; i++) {
                if (dss[i] instanceof SachGiaoKhoa) {
                    SachGiaoKhoa sgk = (SachGiaoKhoa) dss[i];
                    bw.write("Giao khoa," +
                            sgk.getMaSach() + "," + sgk.getTenSach() + "," +
                            sgk.getTheLoai() + "," + sgk.getNamXuatBan() + "," +
                            sgk.getDonGia() + "," + sgk.getSoLuong() + "," +
                            sgk.getTacGia().getMaTG() + "," + sgk.getNhaXuatBan().getMaNXB() + "," +
                            sgk.getLop() + "," + sgk.getMonHoc());
                } else if (dss[i] instanceof SachThamKhao) {
                    SachThamKhao stk = (SachThamKhao) dss[i];
                    bw.write("Tham khao," +
                            stk.getMaSach() + "," + stk.getTenSach() + "," +
                            stk.getTheLoai() + "," + stk.getNamXuatBan() + "," +
                            stk.getDonGia() + "," + stk.getSoLuong() + "," +
                            stk.getTacGia().getMaTG() + "," + stk.getNhaXuatBan().getMaNXB() + "," +
                            stk.getLinhVuc() + "," + stk.getTrinhDo());
                }
                bw.newLine();
            }
            bw.close();
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file" + e.getMessage());
        }
    }

    // vỹ thêm
    public Sach KiemTraMaSach(String maSach) {
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach))
                return dss[i];
        }
        return null;
    }

    public void capNhatSoLuongSach(String maSach, int soLuongMua) {
        if (n < soLuongMua)
            System.out.println("Khong du so luong sach!");
        else
            n -= soLuongMua;
    }

    public void tangSoLuongSach(String maSach, int soLuongNhap) {
        int soLuongSach;
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                soLuongSach = dss[i].getSoLuong();
                int kq = soLuongSach + soLuongNhap;
                dss[i].setSoLuong(kq);
            }
        }
    }

    public void giamSoLuongSach(String maSach, int soLuongMua) {
        int soLuongSach;
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                if (dss[i].getSoLuong() < soLuongMua) {
                    System.out.println("Khong du so luon sach!");
                } else {
                    soLuongSach = dss[i].getSoLuong();
                    int kq = soLuongSach - soLuongMua;
                    dss[i].setSoLuong(kq);
                }
            }
        }
    }

    public boolean kiemTraSoLuongSach(String maSach, int soLuongMua) {
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                if (dss[i].getSoLuong() < soLuongMua)
                    return false;
            }
        }
        return true;
    }

    public double layDonGiaTheoMa(String maSach) {
        double donGia = 0;
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                donGia = dss[i].getDonGia();
            }
        }
        return donGia;
    }
    //

    public Sach laySach(String maSach) {
        for (int i = 0; i < n; i++) {
            if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
                return dss[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DanhSachSach dss = new DanhSachSach();
        dss.docFile();
        dss.xuatSach();
        dss.themSach();
        dss.xuatSach();
    }
}