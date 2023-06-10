package model;

public class NhaSanXuat {
	int MaNSX;
	String TenNSX;
	public NhaSanXuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaSanXuat(int maNSX, String tenNSX) {
		super();
		MaNSX = maNSX;
		TenNSX = tenNSX;
	}
	public int getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(int maNSX) {
		MaNSX = maNSX;
	}
	public String getTenNSX() {
		return TenNSX;
	}
	public void setTenNSX(String tenNSX) {
		TenNSX = tenNSX;
	}
	
}
