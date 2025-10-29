package src.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import src.model.sach.NhaXuatBan;
import src.model.sach.Sach;
import src.model.sach.SachGiaoKhoa;
import src.model.sach.SachThamKhao;
import src.model.sach.TacGia;

public class DanhSachSach {
    private int n;
    private Sach[] s;

    public DanhSachSach() {
        n = 0;
        s = null;
    }

    // Kiểm tra mã sách có duy nhất không?
    public boolean maSachDuyNhat(String maSach, int soLuongHienTai) {
        for (int i = 0; i < soLuongHienTai; i++) {
            if (s[i].getMaSach().equalsIgnoreCase(maSach)) {
                return false;
            }
        }
        return true;
    }

    // Nhập sách
    public void nhapSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach: ");
        n = sc.nextInt();
        sc.nextLine();

        s = new Sach[n];

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
                s[i] = new SachGiaoKhoa();
            } else {
                s[i] = new SachThamKhao();
            }

            s[i].nhap();
        }
    }

    // Xuất danh sách sách
    public void xuatSach() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        System.out.println("----- Danh sach sach -----");
        System.out.printf("%-10s %-10s %-10s %-20s %-20s %-10s %-5s %-10s %-10s %-10s\n", "Ma sach", "Ten sach",
                "The loai", "Nam xuat ban", "Don gia ban", "So luong", "Lop",
                "Mon hoc", "Linh vuc", "Trinh do");
        for (int i = 0; i < n; i++) {
            s[i].xuat();
        }
    }

    // Thêm sách vào danh sách
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

        Sach x;
        if (lc == 1) {
            x = new SachGiaoKhoa();
        } else {
            x = new SachThamKhao();
        }
        x.nhap();

        s = Arrays.copyOf(s, n + 1);
        s[n] = x;
        n++;
    }

    // Hàm xóa sách theo mã
    public void xoaSachTheoMa() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach can xoa: ");
        String maSach = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < n; i++) {
            if (s[i].getMaSach().equalsIgnoreCase(maSach)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma: " + maSach);
            return;
        }

        for (int i = viTri; i < n - 1; i++) {
            s[i] = s[i + 1];
        }

        n--;
        s = Arrays.copyOf(s, n);
    }

    // Sửa thông tin sách tại 1 trường bất kì
    public void suaSachTaiTruong() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach can sua: ");
        String maSach = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < n; i++) {
            if (s[i].getMaSach().equalsIgnoreCase(maSach)) {
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

            System.out.println("1. Ten Sach \n2. The loai \n3. Nam xuat ban \n4. Don gia \n5.So luong");

            if (s[viTri] instanceof SachGiaoKhoa) {
                System.out.println("6. Lop \n7. Mon hoc");
            } else if (s[viTri] instanceof SachThamKhao) {
                System.out.println("6. Linh vuc \n7. Trinh do");
            }

            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            lc = sc.nextInt();
            sc.nextLine();

            switch (lc) {
                case 1:
                    System.out.print("Nhap ten sach moi: ");
                    s[viTri].setTenSach(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap the loai moi: ");
                    s[viTri].setTheLoai(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap nam xuat ban moi: ");
                    s[viTri].setNamXuatBan(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Nhap don gia moi: ");
                    s[viTri].setDonGia(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Nhap so luong moi: ");
                    s[viTri].setSoLuong(sc.nextInt());
                    break;
                case 6:
                    if (s[viTri] instanceof SachGiaoKhoa) {
                        System.out.print("Nhap lop moi: ");
                        ((SachGiaoKhoa) s[viTri]).setLop(sc.nextLine());
                    } else if (s[viTri] instanceof SachThamKhao) {
                        System.out.print("Nhap linh vuc moi: ");
                        ((SachThamKhao) s[viTri]).setLinhVuc(sc.nextLine());
                    }
                    break;
                case 7:
                    if (s[viTri] instanceof SachGiaoKhoa) {
                        System.out.print("Nhap mon hoc moi: ");
                        ((SachGiaoKhoa) s[viTri]).setMonHoc(sc.nextLine());
                    } else if (s[viTri] instanceof SachThamKhao) {
                        System.out.print("Nhap trinh do moi: ");
                        ((SachThamKhao) s[viTri]).setTrinhDo(sc.nextLine());
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

    // === Tìm kiếm ===
    // Tìm kiếm sách theo mã
    public void timKiemSachTheoMa() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach can tim: ");
        String maSach = sc.nextLine();

        boolean timThay = false;

        for (int i = 0; i < n; i++) {
            if (s[i].getMaSach().equalsIgnoreCase(maSach)) {
                s[i].xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach co ma: " + maSach);
        }
    }

    // Tìm kiếm sách theo tên
    public void timKiemSachTheoTen() {
        if (n == 0) {
            System.out.println("Danh sach sach rong!");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten sach can tim: ");
        String tenSach = sc.nextLine();

        boolean timThay = false;

        for (int i = 0; i < n; i++) {
            if (s[i].getTenSach().equalsIgnoreCase(tenSach)) {
                s[i].xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach co ten: " + tenSach);
        }
    }

    // === Thống kê ===
    // Thống kê tổng sách giao khoa, tổng sách tham khao
    public int[] thongKeTongSoSach() {
        int[] tk = new int[2];

        if (n == 0)
            return tk;

        for (int i = 0; i < n; i++) {
            if (s[i] instanceof SachGiaoKhoa) {
                tk[0]++;
            } else if (s[i] instanceof SachThamKhao) {
                tk[1]++;
            }
        }
        return tk;
    }

    // === Ghi file ===
    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("src/data/DanhSachSach.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < n; i++) {
                if (s[i] instanceof SachGiaoKhoa) {
                    SachGiaoKhoa sgk = (SachGiaoKhoa) s[i];
                    bw.write("Giao khoa," +
                            sgk.getMaSach() + "," +
                            sgk.getTenSach() + "," +
                            sgk.getTheLoai() + "," +
                            sgk.getNamXuatBan() + "," +
                            sgk.getDonGia() + "," +
                            sgk.getSoLuong() + "," +
                            sgk.getTacGia().getMaTG() + "," +
                            sgk.getNhaXuatBan().getMaNXB() + "," +
                            sgk.getLop() + "," +
                            sgk.getMonHoc());
                } else if (s[i] instanceof SachThamKhao) {
                    SachThamKhao stk = (SachThamKhao) s[i];
                    bw.write("Tham khao," +
                            stk.getMaSach() + "," +
                            stk.getTenSach() + "," +
                            stk.getTheLoai() + "," +
                            stk.getNamXuatBan() + "," +
                            stk.getDonGia() + "," +
                            stk.getSoLuong() + "," +
                            stk.getTacGia().getMaTG() + "," +
                            stk.getNhaXuatBan().getMaNXB() + "," +
                            stk.getLinhVuc() + "," +
                            stk.getTrinhDo());
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Ghi file thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi ghi file" + e.getMessage());
        }
    }

    // === Đọc file ===
    public void docFile() {
        try {
            FileReader fr = new FileReader("src/data/DanhSachSach.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
            }
            br.close();
            fr.close();

            s = new Sach[count];
            n = 0;

            FileReader fri = new FileReader("src/data/DanhSachSach.txt");
            BufferedReader bri = new BufferedReader(fri);

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

                    TacGia tacGia = new TacGia();
                    tacGia.setMaTG(maTG);
                    NhaXuatBan nhaXuatBan = new NhaXuatBan();
                    nhaXuatBan.setMaNXB(maNXB);

                    if (loai.equalsIgnoreCase("Giao khoa")) {
                        s[n] = new SachGiaoKhoa(maSach, tenSach, theLoai, namXuatBan, donGia, soLuong,
                                tacGia, nhaXuatBan, thuocTinh1, thuocTinh2);
                    } else if (loai.equalsIgnoreCase("Tham khao")) {
                        s[n] = new SachThamKhao(maSach, tenSach, theLoai, namXuatBan, donGia, soLuong,
                                tacGia, nhaXuatBan, thuocTinh1, thuocTinh2);
                    }
                    n++;
                }
            }
            bri.close();
            fri.close();
            System.out.println("Doc file thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi file doc: " + e.getMessage());
        }
    }
}