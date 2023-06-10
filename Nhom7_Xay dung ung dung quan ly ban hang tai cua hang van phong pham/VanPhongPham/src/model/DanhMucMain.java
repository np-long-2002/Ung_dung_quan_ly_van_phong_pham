package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMucMain{
	private String kind;
	private JPanel jpn;
	private JLabel jlb;
	public DanhMucMain(String kind, JPanel jpn, JLabel jlb) {
		super();
		this.kind = kind;
		this.jpn = jpn;
		this.jlb = jlb;
	}
	public DanhMucMain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getKind() {
		return kind;
	}
	public JPanel getJpn() {
		return jpn;
	}
	public JLabel getJlb() {
		return jlb;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setJpn(JPanel jpn) {
		this.jpn = jpn;
	}
	public void setJlb(JLabel jlb) {
		this.jlb = jlb;
	}
	
}
