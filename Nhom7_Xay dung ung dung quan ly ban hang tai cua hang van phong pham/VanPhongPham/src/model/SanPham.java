package model;

public class SanPham {
	int MaSanPham;
	String TenSanPham;
	String MaLoaiSP;
	String MaNSX;
	int GiaNhap;
	int GiaBan;
	int SoLuong;
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(int maSanPham, String tenSanPham, String maLoaiSP, String maNSX, int giaNhap, int giaBan, int soLuong) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		MaLoaiSP = maLoaiSP;
		MaNSX = maNSX;
		GiaNhap = giaNhap;
		GiaBan = giaBan;
		SoLuong = soLuong;
	}
	public int getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public String getMaLoaiSP() {
		return MaLoaiSP;
	}
	public void setMaLoaiSP(String maLoaiSP) {
		MaLoaiSP = maLoaiSP;
	}
	public String getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(String maNSX) {
		MaNSX = maNSX;
	}
	public int getGiaNhap() {
		return GiaNhap;
	}
	public void setGiaNhap(int giaNhap) {
		GiaNhap = giaNhap;
	}
	public int getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(int giaBan) {
		GiaBan = giaBan;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	
}
