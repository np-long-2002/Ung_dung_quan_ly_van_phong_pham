package model;

public class ChiTietHoaDon {
	int MaChiTietHD;
	int MaHoaDon;
	int MaSanPham;
	int SoLuong;
	int TongTien;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(int maChiTietHD, int maHoaDon, int maSanPham, int soLuong, int tongTien) {
		super();
		MaChiTietHD = maChiTietHD;
		MaHoaDon = maHoaDon;
		MaSanPham = maSanPham;
		SoLuong = soLuong;
		TongTien = tongTien;
	}
	public int getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(int maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public int getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	
}
