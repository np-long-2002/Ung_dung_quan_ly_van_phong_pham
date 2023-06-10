package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.ChucVu;
import model.NguoiDung;
import model.NhanVien;


public class ChucVuDAO extends ConnectDatabase{
	public ArrayList<ChucVu> docLS(){
		ArrayList<ChucVu> arrayList = new ArrayList<ChucVu>();
		try {
			String sql = "Select MaChucVu, TenChucVu from ChucVu";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				ChucVu Cv= new ChucVu();
				Cv.setMaChucVu(set.getInt(1));
				Cv.setTenChucVu(set.getString(2));
				arrayList.add(Cv);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;

	}
	public ArrayList<NhanVien> docLS1(){
		ArrayList<NhanVien> arrayList = new ArrayList<NhanVien>();
		try {
			String sql = "Select MaNhanVien,TenNhanVien,ChucVu.TenChucVu from ChucVu,NhanVien Where ChucVu.MaChucVu = NhanVien.MaChucVu";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				NhanVien Nv= new NhanVien();
				Nv.setMaNhanVien(set.getInt(1));
				Nv.setTenNhanVien(set.getString(2));
				Nv.setMaChucVu(set.getString(6));
				arrayList.add(Nv);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;

	}
	public int ThemChucVu(ChucVu cv) {
		try {
			String sql = "insert into ChucVu values (?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,cv.getTenChucVu());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public int capnhapChucVu(ChucVu cv) {
		try { 
			String sql = "update ChucVu set TenChucVu= ? where MaChucVu= ? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(2, cv.getMaChucVu());
			preparedStatement.setString(1,cv.getTenChucVu());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public boolean xoaCV(String maChucVu ) {
		try {
			String sql ="delete from ChucVu where MaChucVu =?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maChucVu);
			return preparedStatement.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}

