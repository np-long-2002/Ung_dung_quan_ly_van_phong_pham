package model;

public class Quyen {
	int MaQuyen;
	String TenQuyen;
	public Quyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quyen(int maQuyen, String tenQuyen) {
		super();
		MaQuyen = maQuyen;
		TenQuyen = tenQuyen;
	}
	public int getMaQuyen() {
		return MaQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		MaQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return TenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		TenQuyen = tenQuyen;
	}
	
}
