package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ChucVu;
import model.NguoiDung;
import model.NguoiDung_1;
import model.Quyen;

public class NguoiDungDAO extends ConnectDatabase{
	public boolean checkDangNhap(String tk, String mk){
		boolean check;
		try {
			String sql = "select * from NguoiDung where TenDangNhap = ? and MatKhau = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tk);
			preparedStatement.setString(2, mk);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()) {
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<NguoiDung_1> docLS(){
		ArrayList<NguoiDung_1> arrayList = new ArrayList<NguoiDung_1>();
		try {
			String sql = "Select MaNguoiDung,TenNhanVien,TenDangNhap,MatKhau,Quyen.TenQuyen from NhanVien,Quyen,NguoiDung Where Quyen.MaQuyen = NguoiDung.MaQuyen and NhanVien.MaNhanVien = NguoiDung.MaNhanVien";			
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				NguoiDung_1 Nd= new NguoiDung_1();
				Nd.setMaNguoiDung(set.getInt(1));
				Nd.setMaNhanVien(set.getString(2));
				Nd.setTenDangNhap(set.getString(3));
				Nd.setMatKhau(set.getString(4));
				Nd.setMaQuyen(set.getString(5));
				arrayList.add(Nd);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
	public int ThemTaiKhoan(NguoiDung_1 tk) {
		try {
			String sql = "insert into NguoiDung(MaNhanVien,TenDangNhap,MatKhau,MaQuyen) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,tk.getMaNhanVien());
			preparedStatement.setString(2, tk.getTenDangNhap());
			preparedStatement.setString(3, tk.getMatKhau());
			preparedStatement.setString(4,tk.getMaQuyen());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public boolean xoaTaiKhoa(String maNguoiDung) {
		try {
			String sql ="delete from NguoiDung where MaNguoiDung =?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maNguoiDung);
			return preparedStatement.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public int capnhapTaiKhoan(NguoiDung_1 nd) {
		try { 
			String sql = "update NguoiDung set MaNhanVien=?,TenDangNhap=?,MatKhau=?,MaQuyen=? where MaNguoiDung=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(5, nd.getMaNguoiDung());
			preparedStatement.setString(1,nd.getMaNhanVien());
			preparedStatement.setString(2, nd.getTenDangNhap());
			preparedStatement.setString(3, nd.getMatKhau());
			preparedStatement.setString(4,nd.getMaQuyen());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<Quyen> ds(){
		ArrayList<Quyen> arrayList = new ArrayList<Quyen>();
		try {
			String sql = "Select * from Quyen";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				Quyen q= new Quyen();
				q.setMaQuyen(set.getInt(1));
				q.setTenQuyen(set.getString(2));
				arrayList.add(q);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;

		
	}
}
