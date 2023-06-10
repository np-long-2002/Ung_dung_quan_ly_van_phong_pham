package model;

public class NhanVien {
	int MaNhanVien;
	String TenNhanVien;
	String GioiTinh;
	String NgayVaoLam;
	String SoDienThoai;
	String MaChucVu;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(int maNhanVien, String tenNhanVien, String gioiTinh, String ngayVaoLam, String soDienThoai,
			String maChucVu) {
		super();
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		GioiTinh = gioiTinh;
		NgayVaoLam = ngayVaoLam;
		SoDienThoai = soDienThoai;
		MaChucVu = maChucVu;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getNgayVaoLam() {
		return NgayVaoLam;
	}
	public void setNgayVaoLam(String ngayVaoLam) {
		NgayVaoLam = ngayVaoLam;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getMaChucVu() {
		return MaChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		MaChucVu = maChucVu;
	}
	
}
