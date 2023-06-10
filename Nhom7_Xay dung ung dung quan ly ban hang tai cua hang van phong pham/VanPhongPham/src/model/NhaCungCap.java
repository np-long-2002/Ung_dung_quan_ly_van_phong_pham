package model;

public class NhaCungCap {
	int MaNhaCungCap;
	String TenNhaCungCap;
	String DiaChi;
	String SoDienThoai;
	String Email;
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaCungCap(int maNhaCungCap, String tenNhaCungCap, String diaChi, String soDienThoai, String email) {
		super();
		MaNhaCungCap = maNhaCungCap;
		TenNhaCungCap = tenNhaCungCap;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		Email = email;
	}
	public int getMaNhaCungCap() {
		return MaNhaCungCap;
	}
	public void setMaNhaCungCap(int maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}
	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
