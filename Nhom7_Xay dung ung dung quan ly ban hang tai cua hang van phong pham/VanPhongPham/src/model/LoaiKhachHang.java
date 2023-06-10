package model;

public class LoaiKhachHang {
	int MaLoaiKH;
	String TenLoaiKH;
	public LoaiKhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiKhachHang(int maLoaiKH, String tenLoaiKH) {
		super();
		MaLoaiKH = maLoaiKH;
		TenLoaiKH = tenLoaiKH;
	}
	public int getMaLoaiKH() {
		return MaLoaiKH;
	}
	public void setMaLoaiKH(int maLoaiKH) {
		MaLoaiKH = maLoaiKH;
	}
	public String getTenLoaiKH() {
		return TenLoaiKH;
	}
	public void setTenLoaiKH(String tenLoaiKH) {
		TenLoaiKH = tenLoaiKH;
	}
	
}
