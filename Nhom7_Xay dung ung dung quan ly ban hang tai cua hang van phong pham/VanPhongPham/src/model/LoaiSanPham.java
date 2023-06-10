package model;

public class LoaiSanPham {
	int MaLoaiSP;
	String TenLoaiSP;
	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiSanPham(int maLoaiSP, String tenLoaiSP) {
		super();
		MaLoaiSP = maLoaiSP;
		TenLoaiSP = tenLoaiSP;
	}
	public int getMaLoaiSP() {
		return MaLoaiSP;
	}
	public void setMaLoaiSP(int maLoaiSP) {
		MaLoaiSP = maLoaiSP;
	}
	public String getTenLoaiSP() {
		return TenLoaiSP;
	}
	public void setTenLoaiSP(String tenLoaiSP) {
		TenLoaiSP = tenLoaiSP;
	}
	
}
