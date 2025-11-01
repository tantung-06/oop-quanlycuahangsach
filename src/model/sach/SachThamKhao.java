package src.model.sach;

import java.util.Scanner;

public class SachThamKhao extends Sach {
    private String linhVuc;
    private String trinhDo;

    public SachThamKhao() {
    }

    public SachThamKhao(String maSach, String tenSach, String theLoai, int namXuatBan, int donGiaBan, int soLuong,
            TacGia maTG, NhaXuatBan maNXB, String linhVuc, String trinhDo) {
        super(maSach, tenSach, theLoai, namXuatBan, donGiaBan, soLuong, maTG, maNXB);
        this.linhVuc = linhVuc;
        this.trinhDo = trinhDo;
    }

    public SachThamKhao(SachThamKhao sgk) {
        super((Sach) sgk);
        this.linhVuc = sgk.linhVuc;
        this.trinhDo = sgk.trinhDo;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhap linh vuc: ");
        linhVuc = sc.nextLine();
        System.out.print("Nhap trinh do: ");
        trinhDo = sc.nextLine();
    }

    @Override
    public void nhapKhongMa() {
        Scanner sc = new Scanner(System.in);
        super.nhapKhongMa();
        System.out.print("Nhap linh vuc: ");
        linhVuc = sc.nextLine();
        System.out.print("Nhap trinh do: ");
        trinhDo = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" %-15s | %-15s | %-15s | %-15s |\n", "-", "-", linhVuc, trinhDo);
    }

    @Override
    public String loai() {
        return "Tham khao";
    }
}