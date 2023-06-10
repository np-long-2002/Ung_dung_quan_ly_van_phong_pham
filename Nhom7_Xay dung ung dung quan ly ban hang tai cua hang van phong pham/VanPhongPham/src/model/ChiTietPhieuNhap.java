package model;

public class ChiTietPhieuNhap {
	int MaCTPN;
	int MaPhieuNhap;
	int MaSanPham;
	int SoLuong;
	int TongTien;
	public ChiTietPhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietPhieuNhap(int maCTPN, int maPhieuNhap, int maSanPham, int soLuong, int tongTien) {
		super();
		MaCTPN = maCTPN;
		MaPhieuNhap = maPhieuNhap;
		MaSanPham = maSanPham;
		SoLuong = soLuong;
		TongTien = tongTien;
	}
	public int getMaCTPN() {
		return MaCTPN;
	}
	public void setMaCTPN(int maCTPN) {
		MaCTPN = maCTPN;
	}
	public int getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(int maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
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
