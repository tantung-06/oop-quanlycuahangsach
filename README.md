QuanLyCuaHangSach/
│
├── src/
│ │
│ ├── data/ # Thư mục chứa file dữ liệu
│ │ ├── DanhSachChiTietHoaDon.txt
│ │ ├── DanhSachChiTietPhieuNhap.txt
│ │ ├── DanhSachHoaDon.txt
│ │ ├── DanhSachKhachHang.txt
│ │ ├── DanhSachNhaCungCap.txt
│ │ ├── DanhSachNhanVien.txt
│ │ ├── DanhSachNhaXuatBan.txt
│ │ ├── DanhSachPhieuNhap.txt
│ │ ├── DanhSachSach.txt
│ │ └── DanhSachTacGia.txt
│ │
│ ├── main/ # Chương trình chính
│ │ └── Main.java
│ │
│ ├── manager/ # Quản lý danh sách từng đối tượng
│ │ ├── DanhSachChiTietHoaDon.java
│ │ ├── DanhSachChiTietPhieuNhap.java
│ │ ├── DanhSachHoaDon.java
│ │ ├── DanhSachKhachHang.java
│ │ ├── DanhSachNhaCungCap.java
│ │ ├── DanhSachNhanVien.java
│ │ ├── DanhSachNhaXuatBan.java
│ │ ├── DanhSachPhieuNhap.java
│ │ ├── DanhSachSach.java
│ │ ├── DanhSachTacGia.java
| | └── QuanLyCuaHangSach.java
│ │
│ ├── model/ # Các lớp mô hình dữ liệu
│ │ ├── doitac/
│ │ │ ├── KhachHang.java
│ │ │ └── NhaCungCap.java
│ │ │
│ │ ├── hoadon/
│ │ │ ├── ChiTietHoaDon.java
│ │ │ └── HoaDon.java
│ │ │
│ │ ├── nhansu/
│ │ │ └── NhanVien.java
│ │ │
│ │ ├── phieunhap/
│ │ │ ├── ChiTietPhieuNhap.java
│ │ │ └── PhieuNhap.java
│ │ │
│ │ └── sach/
│ │ ├── NhaXuatBan.java
│ │ ├── Sach.java
│ │ ├── SachGiaoKhoa.java
│ │ ├── SachThamKhao.java
│ │ └── TacGia.java
│ │

=== QUY TRÌNH CHẤM ĐỒ ÁN ===

1. 4 bạn ngồi gần nhau
2. 1 bạn chạy đề mô
3. tính hợp lệ: coi có trùng mã không, update số lượng
4. mỗi thành viên sẽ chọn gói điểm cho bản thân

- không code lại: 1đ
- 50%: làm tối thiểu 3 lớp danh sách - cô sẽ chọn hàm bất kì để code lại
- 70%: tối thiểu 7 lớp danh sách phải code được thống kê
- 100%: cô chỉ chỗ nào code lại chỗ đó
- gói zero điểm quá trình không code lại đc gói mình chọn
  Ghi chú: nếu điểm ra không thỏa đáng bạn có thể xin chấm lại trước khi kí tên

=== CHỨC NĂNG CỦA DANH SÁCH ===

1. Xem danh sách
2. Thêm
3. Xóa theo mã
4. Sửa thông tin tại 1 trường
5. Tìm kiếm: theo mã, theo tên
6. Thống kê: 1 or 2
7. Đọc file
8. Ghi file

== Xong ==

1. Tac gia : oke
2. Sach : oke
3. Nha xuat ban : oke
4. Nhan vien : oke
5. Nha cung cap : oke
6. Khach hang : oke
7. Hoa don: chưa
8. Phieu nhap: chưa

== Yêu cầu ==

- nhập dữ liệu và tính toán:

1. dữ liệu sản phẩm
   Nhập Masp, ten sp, so luong , don gia,

- số lượng:
  th1: nếu bán hàng (cthd) -> trừ bớt số lượng
  th2: nhập hàng (ctnh)-> cộng thêm vào số lượng

2. Chi tiết hóa đơn
   ma hoa don - copy HD qua
   ma san pham - nhập ràng buộc
   so luong ban - nhập ràng buộc
   đơn giá bán - copy từ đơn giá của sản phẩm
   thành tiền - tính toán = số lượng x đơn giá
   -copy đơn giá:
   làm sao lấy đc đơn giá của sản phẩm
   gọi hàm tìm sp theo mã trả về sp tìm
3. Chi tiết phiếu nhập
   ma phiếu nhập - copy từ phiếu nhập
   ma sản phẩm - nhập
   số lượng - nhập
   đơn giá - nhập
   thành tiền - tính toán
4. Phiếu nhập:
   ma pn - nhập
   ma ncc - nhâp ràng buộc
   ma nv - nhập ràng buộc
   ngày lập - nhập
   tổng tiền - tính = tổng của các thành tiền
5. Hóa đơn:
   ma hd - nhập
   ma nv - nhâp ràng buộc
   ma kh - nhập ràng buộc
   ngày lập - nhập
   tổng tiền - tính = tổng của các thành tiền
6. Tuyền dl cho đối tượng
   sử dụng hàm thiết lập có tham số or set thuộc tính

// cập nhật số lượng khi bán hàng hoặc nhập hàng
public void capNhatSoLuong(String maSach, int soLuongThayDoi, boolean laNhapHang) {
for (int i = 0; i < n; i++) {
if (dss[i].getMaSach().equalsIgnoreCase(maSach)) {
int soLuongHienTai = dss[i].getSoLuong();
if (laNhapHang) {
// nhập hàng cộng thêm vào số lượng
dss[i].setSoLuong(soLuongHienTai + soLuongThayDoi);
System.out.println("Da nhap them " + soLuongThayDoi + " quyen vao ma sach " + maSach);
} else {
// bán hàng trừ bớt số lượng
if (soLuongThayDoi > soLuongHienTai) {
System.out.println("Khong du so luong de ban, so luong ton: " + soLuongHienTai);
} else {
dss[i].setSoLuong(soLuongHienTai - soLuongThayDoi);
System.out.println(
"Da ban " + soLuongThayDoi + " quyen, so luong con lai: " + dss[i].getSoLuong());
}
}
return;
}
}
System.out.println("Khong tim thay sach co ma: " + maSach);
}
