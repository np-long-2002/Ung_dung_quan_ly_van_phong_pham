package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.HoaDon;
import model.ItemSanPham;
import model.ItemThongKe;
import model.LoaiSanPham;
import model.NhanVien;
import model.SanPham;

public class NhanVienDAO extends ConnectDatabase{
	public ArrayList<NhanVien> getALlNhanVien(){
		ArrayList<NhanVien> arrayList = new ArrayList<NhanVien>();
		try {
			String sql = "select * from NhanVien";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(rs.getInt("MaNhanVien"));
				nv.setTenNhanVien(rs.getString("TenNhanVien"));
				nv.setGioiTinh(rs.getString("GioiTinh"));
				nv.setNgayVaoLam(rs.getString("NgayVaoLam"));
				nv.setSoDienThoai(rs.getString("SoDienThoai"));
				nv.setMaChucVu(rs.getString("MaChucVu"));
				arrayList.add(nv);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}

	public NhanVien getNhanVienByName(String name){
		try {
			String sql = "select * from NhanVien WHERE TenNhanVien = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(rs.getInt("MaNhanVien"));
				nv.setTenNhanVien(rs.getString("TenNhanVien"));
				nv.setGioiTinh(rs.getString("GioiTinh"));
				nv.setNgayVaoLam(rs.getString("NgayVaoLam"));
				nv.setSoDienThoai(rs.getString("SoDienThoai"));
				nv.setMaChucVu(rs.getString("MaChucVu"));
				rs.close();
				pstmt.close();
				return nv;
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<NhanVien> docLS(){
		ArrayList<NhanVien> arrayList = new ArrayList<NhanVien>();
		try {
			String sql = "Select MaNhanVien,TenNhanVien,GioiTinh,NgayVaoLam,SoDienThoai,ChucVu.TenChucVu from ChucVu,NhanVien Where ChucVu.MaChucVu = NhanVien.MaChucVu";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				NhanVien nv= new NhanVien();
				nv.setMaNhanVien(set.getInt(1));
				nv.setTenNhanVien(set.getString(2));
				nv.setGioiTinh(set.getString(3));
				nv.setNgayVaoLam(set.getString(4));
				nv.setSoDienThoai(set.getString(5));
				nv.setMaChucVu(set.getString(6));
				arrayList.add(nv);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;

	}
	public int ThemNhanVien(NhanVien nv) {
		try {
			String sql = "insert into NhanVien(TenNhanVien,GioiTinh,SoDienThoai,MaChucVu) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,nv.getTenNhanVien());
			preparedStatement.setString(2, nv.getGioiTinh());
			preparedStatement.setString(3,nv.getSoDienThoai());
			preparedStatement.setString(4,nv.getMaChucVu());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public boolean xoaNv(String maNhanVien) {
		try {
			String sql ="delete from NhanVien where MaNhanVien =?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVien);
			return preparedStatement.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public int capnhapNv(NhanVien nv) {
		try { 
			String sql = "update NhanVien set TenNhanVien=?,GioiTinh=?,SoDienThoai=?,MaChucVu=? where MaNhanVien=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,nv.getTenNhanVien());
			preparedStatement.setString(2, nv.getGioiTinh());
			preparedStatement.setString(3,nv.getSoDienThoai());
			preparedStatement.setString(4,nv.getMaChucVu());
			preparedStatement.setInt(5,nv.getMaNhanVien());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<NhanVien> Tknv(String ten){
		ArrayList<NhanVien> arrayList = new ArrayList<NhanVien>();
		try {
			String sql = "	SELECT DISTINCT * FROM NhanVien  WHERE TenNhanVien LIKE '%"+ten+"%'";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				NhanVien Nv= new NhanVien();
				Nv.setMaNhanVien(set.getInt(1));
				Nv.setTenNhanVien(set.getString(2));
				Nv.setGioiTinh(set.getString(3));
				Nv.setNgayVaoLam(set.getString(4));
				Nv.setSoDienThoai(set.getString(5));
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
}
