package src.model.sach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TacGia {
    private String maTG;
    private String ho;
    private String ten;
    private LocalDate ngaySinh;
    private String quocTich;

    public TacGia() {
    }

    public TacGia(String maTG, String ho, String ten, LocalDate ngaySinh, String quocTich) {
        this.maTG = maTG;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.quocTich = quocTich;
    }

    public TacGia(TacGia tg) {
        this.maTG = tg.maTG;
        this.ho = tg.ho;
        this.ten = tg.ten;
        this.ngaySinh = tg.ngaySinh;
        this.quocTich = tg.quocTich;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
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

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhap ma tac gia: ");
        maTG = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
        String ns = sc.nextLine();
        ngaySinh = LocalDate.parse(ns, f);
        System.out.print("Nhap quoc tich: ");
        quocTich = sc.nextLine();
    }

    public void xuat() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-15s %-10s %-10s %-12s %-12s\n", maTG, ho, ten, ngaySinh.format(f), quocTich);
    }
}
