package src.model.sach;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;
    private String diaChi;

    public NhaXuatBan() {

    }

    public NhaXuatBan(String maNXB, String tenNXB, String diaChi) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
    }

    public NhaXuatBan(NhaXuatBan nxb) {
        this.maNXB = nxb.maNXB;
        this.tenNXB = nxb.tenNXB;
        this.diaChi = nxb.tenNXB;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String hamMaNXB() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        boolean check = true;
        System.out.print("Ma nha xuat ban(5 ky tu): ");
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

    public void nhap() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap thong tin nha xuat ban");
        System.out.print("Ten nha xuat ban: ");
        tenNXB = in.readLine();
        tenNXB = tenNXB.trim().replaceAll("\\s+", " ");// Xoa khoang cach du thua

        System.out.print("Ma nha xuat ban: ");
        maNXB = hamMaNXB();

        System.out.print("Dia chi: ");
        diaChi = in.readLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-30s %-30s\n",
                maNXB, tenNXB, diaChi);
    }

    public void suaThongTin() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("""
                    Ban muon thay doi thong tin gi!
                    1. Ten nha xuat ban
                    2. Ma nha xuat ban
                    3. Dia chi
                    0. Khong thay doi gi nua""");
            int choice;
            System.out.print("Lua chon: ");
            choice = Integer.parseInt(in.readLine());

            switch (choice) {
                case 1: {
                    System.out.print("Ten nha xuat ban: ");
                    tenNXB = in.readLine();
                    tenNXB = tenNXB.trim().replaceAll("\\s+", " ");// Xoa khoang cach du thua
                    break;
                }
                case 2: {
                    System.out.print("Ma nha xuat ban: ");
                    maNXB = hamMaNXB();
                    break;
                }
                case 3: {
                    System.out.print("Dia chi: ");
                    diaChi = in.readLine();
                    break;
                }
                case 0:
                    return;
                default:
                    System.out.println("Cu phap khong hop le, hay nhap lai");
                    break;
            }
        }
    }
}
