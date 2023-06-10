package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.HoaDon;
import model.ItemPhieuNhap;
import model.ItemSanPham;
import model.ItemThongKe;
import model.LoaiSanPham;
import model.SanPham;

public class PhieuNhapDAO extends ConnectDatabase{
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/*
	select pn.MaPhieuNhap,nv.TenNhanVien,pn.TongTien,ncc.TenNhaCungCap,pn.NgayNhap  from PhieuNhap pn
	JOIN NhanVien nv ON pn.MaNhanVien = nv.MaNhanVien
	JOIN NhaCungCap ncc ON ncc.MaNhaCungCap = pn.MaNhaCungCap;
	 */
	public ArrayList<ItemPhieuNhap> getAllPhieuNhap(){
		
		
		ArrayList<ItemPhieuNhap> arrayList = new ArrayList<ItemPhieuNhap>();
		try {
			String sql = "select pn.MaPhieuNhap,nv.TenNhanVien,pn.TongTien,ncc.TenNhaCungCap,pn.NgayNhap  from PhieuNhap pn" +
			" JOIN NhanVien nv ON pn.MaNhanVien = nv.MaNhanVien"+
			" JOIN NhaCungCap ncc ON ncc.MaNhaCungCap = pn.MaNhaCungCap;";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ItemPhieuNhap item = new ItemPhieuNhap();
				item.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
				item.setTenNhanVien(rs.getString("TenNhanVien"));
				item.setTongTien(rs.getLong("TongTien"));
				item.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
				Date ngayLap = dateFormat.parse(rs.getString("NgayNhap"));
				item.setNgayNhap(sdf.format(ngayLap));
				//item.setNgayNhap("2020");
				arrayList.add(item);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}
	public int insertPhieuNhap(int maNhanVien,int maNhaCungCap, long tongTien, String ngayNhap) {
		Date ngayNhapDate = new Date();
		try {
			ngayNhapDate = sdf.parse(ngayNhap);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -2;
		}
		try {
			String sql = "INSERT INTO PhieuNhap(MaNhanVien,MaNhaCungCap,TongTien,NgayNhap) VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, maNhanVien);
			pstmt.setInt(2, maNhaCungCap);
			pstmt.setLong(3, tongTien);
			pstmt.setString(4, dateFormat.format(ngayNhapDate).toString());
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
	public boolean updatePhieuNhap(int maPhieuNhap,int maNhanVien,int maNhaCungCap, long tongTien, String ngayNhap) {
		Date ngayNhapDate = new Date();
		try {
			ngayNhapDate = sdf.parse(ngayNhap);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		try {
			String sql = "UPDATE PhieuNhap SET MaNhanVien=?,MaNhaCungCap=?,TongTien=?,NgayNhap=? WHERE MaPhieuNhap=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maNhanVien);
			pstmt.setInt(2, maNhaCungCap);
			pstmt.setLong(3, tongTien);
			pstmt.setString(4, dateFormat.format(ngayNhapDate).toString());
			pstmt.setInt(5, maPhieuNhap);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePhieuNhap(int maPhieuNhap) {
		try {
			String sql = "DELETE FROM PhieuNhap WHERE MaPhieuNhap=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maPhieuNhap);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
