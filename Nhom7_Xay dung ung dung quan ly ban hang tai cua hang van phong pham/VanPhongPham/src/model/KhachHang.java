package model;

public class KhachHang {
	int MaKhachHang;
	String TenKhachHang;
	String GioiTinh;
	String SoDienThoai;
	String MaLoaiKH;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int maKhachHang, String tenKhachHang, String gioiTinh, String soDienThoai, String maLoaiKH) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		GioiTinh = gioiTinh;
		SoDienThoai = soDienThoai;
		MaLoaiKH = maLoaiKH;
	}
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getMaLoaiKH() {
		return MaLoaiKH;
	}
	public void setMaLoaiKH(String maLoaiKH) {
		MaLoaiKH = maLoaiKH;
	}
	
}
