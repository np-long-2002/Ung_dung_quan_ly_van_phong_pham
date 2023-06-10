package model;

public class HoaDon {
	int MaHoaDon;
	String MaKhachHang;
	String MaNhanVien;
	String NgayLapHoaDon;
	int TongTien;
	String TrangThai;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(int maHoaDon, String maKhachHang, String maNhanVien, String ngayLapHoaDon, int tongTien,
			String trangThai) {
		super();
		MaHoaDon = maHoaDon;
		MaKhachHang = maKhachHang;
		MaNhanVien = maNhanVien;
		NgayLapHoaDon = ngayLapHoaDon;
		TongTien = tongTien;
		TrangThai = trangThai;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getNgayLapHoaDon() {
		return NgayLapHoaDon;
	}
	public void setNgayLapHoaDon(String ngayLapHoaDon) {
		NgayLapHoaDon = ngayLapHoaDon;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	
	
}
