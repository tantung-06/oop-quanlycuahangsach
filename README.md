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
│ ├── ui/ # Menu giao diện
│ │ └── Menu.java
│ │
│ └── utils/ # Xử lí đọc/ghi file
│ └── FileHandle.java
└──

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

1. Xem
2. Thêm
3. Sửa
4. Tìm kiếm: theo mã, theo tên
5. Thống kê: tối thiểu 2 thống kê