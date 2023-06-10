package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.HoaDon;
import model.ItemCTPN;
import model.ItemPhieuNhap;
import model.ItemSanPham;
import model.ItemThongKe;
import model.LoaiSanPham;
import model.SanPham;

public class ChiTietPhieuNhapDAO extends ConnectDatabase{
	/*
	select pn.MaPhieuNhap,nv.TenNhanVien,pn.TongTien,ncc.TenNhaCungCap,pn.NgayNhap  from PhieuNhap pn
	JOIN NhanVien nv ON pn.MaNhanVien = nv.MaNhanVien
	JOIN NhaCungCap ncc ON ncc.MaNhaCungCap = pn.MaNhaCungCap;
	 */
	public ArrayList<ItemCTPN> getAllCTPhieuNhap(){
		ArrayList<ItemCTPN> arrayList = new ArrayList<ItemCTPN>();
		try {
			String sql = "select c.MaCTPN, c.MaPhieuNhap, s.TenSanPham, c.SoLuong, c.TongTien, s.MaSanPham from ChiTietPhieuNhap c JOIN SanPham s ON c.MaSanPham = s.MaSanPham";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ItemCTPN item = new ItemCTPN();
				item.setMaCTPN(rs.getInt("MaCTPN"));
				item.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
				item.setTenSanPham(rs.getString("TenSanPham"));
				item.setSoLuong(rs.getInt("SoLuong"));
				item.setTongTien(rs.getLong("TongTien"));
				item.setMaSanPham(rs.getInt("MaSanPham"));
				arrayList.add(item);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}
	public int insertCTPhieuNhap(int maPhieuNhap, int maSanPham, int soLuong,long tongTien) {
		try {
			String sql = "INSERT INTO ChiTietPhieuNhap(MaPhieuNhap,MaSanPham,SoLuong,TongTien) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, maPhieuNhap);
			pstmt.setInt(2, maSanPham);
			pstmt.setInt(3, soLuong);
			pstmt.setLong(4, tongTien);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				int lastIndex = rs.getInt(1);
				rs.close();
				pstmt.close();
				return lastIndex;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public boolean updateCTPhieuNhap(int maCTPN,int maPhieuNhap,int maSanPham, int soLuong, long tongTien) {
		try {
			String sql = "UPDATE ChiTietPhieuNhap SET MaPhieuNhap=?,MaSanPham=?,SoLuong=?,TongTien=? WHERE MaCTPN=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maPhieuNhap);
			pstmt.setInt(2, maSanPham);
			pstmt.setInt(3, soLuong);
			pstmt.setLong(4, tongTien);
			pstmt.setInt(5, maCTPN);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCTPhieuNhap(int maCTPN) {
		try {
			String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaCTPN=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maCTPN);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
