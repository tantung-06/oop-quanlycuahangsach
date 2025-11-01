package src.main;

import java.util.Scanner;

import src.manager.DanhSachKhachHang;
import src.manager.DanhSachSach;
import src.model.doitac.KhachHang;
import src.model.doitac.NhaCungCap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // DanhSachKhachHang s = new DanhSachKhachHang();
        // s.nhapKhachHang();
        // s.xuatKhachHang();
        // NhaCungCap ncc = new NhaCungCap();
        // ncc.nhap();
        // ncc.xuat();
        DanhSachSach s = new DanhSachSach();
        s.docFile();
        // s.nhapSach();
        // s.themSach();
        s.xuatSach();
        DanhSachKhachHang kh = new DanhSachKhachHang();
        // kh.nhapKhachHang();
        // kh.xuatKhachHang();
        // kh.xoaKhachHang();
        // kh.xuatKhachHang();
        kh.docFile();
        // kh.nhapKhachHang();
        kh.xuatKhachHang();
    }
}