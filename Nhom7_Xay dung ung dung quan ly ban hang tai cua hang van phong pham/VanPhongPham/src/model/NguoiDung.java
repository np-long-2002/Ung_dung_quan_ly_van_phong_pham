package model;

public class NguoiDung {
	int MaNguoiDung;
	String MaNhanVien;
	String TenDangNhap;
	String MatKhau;
	int MaQuyen;
	public NguoiDung() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NguoiDung(int maNguoiDung, String maNhanVien, String tenDangNhap, String matKhau, int maQuyen) {
		super();
		MaNguoiDung = maNguoiDung;
		MaNhanVien = maNhanVien;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		MaQuyen = maQuyen;
	}
	public int getMaNguoiDung() {
		return MaNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public int getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		MaQuyen = maQuyen;
	}
	
}
