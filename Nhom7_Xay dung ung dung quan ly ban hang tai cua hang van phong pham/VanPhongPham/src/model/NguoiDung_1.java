package model;

public class NguoiDung_1 {
	int MaNguoiDung;
	String MaNhanVien;
	String TenDangNhap;
	String MatKhau;
	String MaQuyen;
	public NguoiDung_1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NguoiDung_1(int maNguoiDung, String maNhanVien, String tenDangNhap, String matKhau, String maQuyen) {
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
	public String getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(String maQuyen) {
		MaQuyen = maQuyen;
	}
	
}
