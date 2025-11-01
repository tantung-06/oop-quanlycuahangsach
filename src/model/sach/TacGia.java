package src.model.sach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TacGia {
    private String maTG;
    private String tenTG;
    private LocalDate ngaySinh;
    private String quocTich;

    public TacGia() {
    }

    public TacGia(String maTG, String tenTG, LocalDate ngaySinh,
            String quocTich) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.ngaySinh = ngaySinh;
        this.quocTich = quocTich;

    }

    public TacGia(TacGia tg) {
        this.maTG = tg.maTG;
        this.tenTG = tg.tenTG;
        this.ngaySinh = tg.ngaySinh;
        this.quocTich = tg.quocTich;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
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
        System.out.print("Nhap ten tac gia: ");
        tenTG = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        String ns = sc.nextLine();
        ngaySinh = LocalDate.parse(ns, f);
        System.out.print("Nhap quoc tich: ");
        quocTich = sc.nextLine();
    }

    public void xuat() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", maTG, tenTG, ngaySinh.format(f), quocTich);
    }
}
