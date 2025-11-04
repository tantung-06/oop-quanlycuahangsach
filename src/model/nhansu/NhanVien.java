package src.model.nhansu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NhanVien {
    private String maNV;
    private String ho;
    private String ten;
    private String chucVu;
    private float luong;
    private String SDT;

    public NhanVien() {

    }

    public NhanVien(String maNV, String hoTen, String ho, String ten, String chucVu,
            float luong, String SDT) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.chucVu = chucVu;
        this.luong = luong;
        this.SDT = SDT;
    }

    public NhanVien(NhanVien nv) {
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.chucVu = nv.chucVu;
        this.luong = nv.luong;
        this.SDT = nv.SDT;
    }

    public NhanVien(String maNV) {// thêm cái này nữa nè
        this.maNV = maNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String hamMaNV() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        boolean check = true;
        System.out.print("Ma nhan vien (5 ky tu): ");
        while (check) {
            temp = in.readLine();
            check = false;
            if (temp.length() != 5) {
                check = true;
                System.out.println("Cu phap khong dung! Hay nhap lai: ");
            }
        }

        return temp;
    }

    public String hamChucVu() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        while (true) {
            System.out.println("""
                    Chon chuc vu!
                    1. Quan ly
                    2. Nhan vien
                    3. Thu ngan
                    4. Ban hang
                    5. Bao ve""");
            System.out.print("Chon chuc vu: ");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1:
                    return "Quan ly";
                case 2:
                    return "Nhan vien";
                case 3:
                    return "Thu ngan";
                case 4:
                    return "Ban hang";
                case 5:
                    return "Bao ve";
                default:
                    System.out.println("Chon khong dung!");
            }
        }
    }

    public String hamSDT() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        boolean check = true;
        System.out.print("So dien thoai (10 so): ");
        while (check) {
            temp = in.readLine();
            check = false;
            if (temp.length() != 10 || temp.matches(".*[a-zA-Z].*")) { // Kiem tra du 10 so, va khong co chu
                check = true;
                System.out.println("Cu phap khong dung! Hay nhap lai: ");
            }
        }

        return temp;
    }

    public void nhap() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap thong tin nhan vien");

        maNV = hamMaNV();// Nhap ma nv

        System.out.print("Ho nhan vien: ");
        ho = in.readLine();
        ho = ho.trim().replaceAll("\\s+", " ");

        System.out.print("Ten nhan vien: ");
        ten = in.readLine();
        ten = ten.trim().replaceAll("\\s+", " ");

        chucVu = hamChucVu();// Nhap chuc Vu

        SDT = hamSDT();// Nhap so dien thoai
        System.out.print("Luong: ");
        luong = Integer.parseInt(in.readLine());
    }

    public void xuatNV() {
        System.out.printf("%-10s %-10s %-10s %-15s %-15.2f %-15s\n",
                maNV, ho, ten, chucVu,
                luong, SDT);
    }

    public void suaThongTin() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("""
                    Ban muon thay doi thong tin gi!
                    1. Ho ten nhan vien
                    2. Chuc vu
                    3. Luong
                    4. So dien thoai
                    0. Khong thay doi gi nua""");
            int choice;
            System.out.print("Lua chon: ");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1: {
                    System.out.print("Ho nhan vien: ");
                    ho = in.readLine();
                    ho = ho.trim().replaceAll("\\s+", " ");

                    System.out.print("Ten nhan vien: ");
                    ten = in.readLine();
                    ten = ten.trim().replaceAll("\\s+", " ");
                    break;
                }
                case 2: {
                    chucVu = hamChucVu();// Nhap chuc Vu
                    break;
                }
                case 3: {
                    System.out.print("Luong: ");
                    luong = Integer.parseInt(in.readLine());
                    break;
                }
                case 4: {
                    SDT = hamSDT();// Nhap so dien thoai
                    break;
                }
                case 0:
                    return;
                default: {
                    System.out.print("Cu phap khong dung, hay nhap lai!");
                    break;
                }
            }
        }

    }
}