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
import model.SanPham;

public class LoaiSanPhamDAO extends ConnectDatabase{
	public ArrayList<LoaiSanPham> getAllLoaiSanPham(){
		ArrayList<LoaiSanPham> arrayList = new ArrayList<LoaiSanPham>();
		try {
			String sql = "select * from LoaiSanPham";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				LoaiSanPham lsp = new LoaiSanPham();
				lsp.setMaLoaiSP(rs.getInt(1));
				lsp.setTenLoaiSP(rs.getString(2));
				arrayList.add(lsp);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}
	public int insertLoaiSanPham(String tenLoaiSP) {
		try {
			String sql = "INSERT INTO LoaiSanPham(TenLoaiSP) VALUES(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, tenLoaiSP);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				int maSanPham = rs.getInt(1);
				rs.close();
				pstmt.close();
				return maSanPham;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public boolean updateLoaiSanPham(int maLoaiSP, String tenSanPham) {
		try {
			String sql = "UPDATE LoaiSanPham SET TenLoaiSP=? WHERE MaLoaiSP=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tenSanPham);
			pstmt.setInt(2, maLoaiSP);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteLoaiSanPham(int maLoaiSP) {
		try {
			String sql = "DELETE FROM LoaiSanPham WHERE MaLoaiSP=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maLoaiSP);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
