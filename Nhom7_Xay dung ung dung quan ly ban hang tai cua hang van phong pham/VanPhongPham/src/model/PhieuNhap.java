package model;

public class PhieuNhap {
	int MaPhieuNhap;
	int MaNhanVien;
	int MaNhaCungCap;
	int TongTien;
	String NgayNhap;
	public PhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhieuNhap(int maPhieuNhap, int maNhanVien, int maNhaCungCap, int tongTien, String ngayNhap) {
		super();
		MaPhieuNhap = maPhieuNhap;
		MaNhanVien = maNhanVien;
		MaNhaCungCap = maNhaCungCap;
		TongTien = tongTien;
		NgayNhap = ngayNhap;
	}
	public int getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(int maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public int getMaNhaCungCap() {
		return MaNhaCungCap;
	}
	public void setMaNhaCungCap(int maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	public String getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		NgayNhap = ngayNhap;
	}
	
}
