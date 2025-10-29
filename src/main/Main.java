package src.main;

import java.util.Scanner;
import src.manager.DanhSachSach;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachSach s = new DanhSachSach();
        s.docFile();
        s.xuatSach();
        s.themSach();
        s.ghiFile();
    }
}