package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.LoaiSanPham;
import model.HoaDon;
import model.ItemSanPham;
import model.ItemThongKe;
import model.SanPham;

public class SanPhamDAO extends ConnectDatabase{
	public ArrayList<ItemSanPham> getAllSanPham(){
		ArrayList<ItemSanPham> arrayList = new ArrayList<ItemSanPham>();
		try {
			String sql = "select sp.MaSanPham,sp.TenSanPham,lsp.TenLoaiSP,sp.GiaNhap,sp.GiaBan,nsx.TenNSX,sp.SoLuong,lsp.MaLoaiSP from SanPham sp \n" +
                "JOIN LoaiSanPham lsp ON sp.MaLoaiSP = lsp.MaLoaiSP\n" +
                "JOIN NhaSanXuat nsx ON sp.MaNSX = nsx.MaNSX;";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ItemSanPham sp = new ItemSanPham();
				sp.setMaSanPham(rs.getInt(1));
				sp.setTenSanPham(rs.getString(2));
				sp.setTenLoaiSanPham(rs.getString(3));
				sp.setGiaNhap(rs.getInt(4));
				sp.setGiaBan(rs.getInt(5));
				sp.setTenNhaSanXuat(rs.getString(6));
				sp.setSoLuongTon(rs.getInt(7));
				sp.setMaLoaiSanPham(rs.getInt(8));
				arrayList.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	public int insertSanPham(String tenSanPham,String maLoaiSP, int giaNhap, int giaBan, String maNSX, int soLuongTon) {
		try {
			String sql = "INSERT INTO SanPham(TenSanPham, MaLoaiSP, GiaNhap, GiaBan, MaNSX, SoLuong) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, tenSanPham);
			pstmt.setString(2, maLoaiSP);
			pstmt.setInt(3, giaNhap);
			pstmt.setInt(4, giaBan);
			pstmt.setString(5, maNSX);
			pstmt.setInt(6, soLuongTon);
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
	public boolean updateSanPham(int maSanPham, String tenSanPham, String maLoaiSP, int giaNhap, int giaBan, String maNSX, int soLuongTon) {
		try {
			String sql = "UPDATE SanPham SET TenSanPham=?, MaLoaiSP=?, GiaNhap=?, GiaBan=?, MaNSX=?, SoLuong=? WHERE MaSanPham=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tenSanPham);
			pstmt.setString(2, maLoaiSP);
			pstmt.setInt(3, giaNhap);
			pstmt.setInt(4, giaBan);
			pstmt.setString(5, maNSX);
			pstmt.setInt(6, soLuongTon);
			pstmt.setInt(7, maSanPham);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteSanPham(int maSanPham) {
		try {
			String sql = "DELETE FROM SanPham WHERE MaSanPham=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maSanPham);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<LoaiSanPham> docLSP(){
		ArrayList<LoaiSanPham> arrayList = new ArrayList<LoaiSanPham>();
		try {
			String sql = "Select * from LoaiSanPham";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				LoaiSanPham lsp= new LoaiSanPham();
				lsp.setMaLoaiSP(set.getInt(1));
				lsp.setTenLoaiSP(set.getString(2));
				arrayList.add(lsp);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
}
	public int luuLSP(LoaiSanPham lsp) {
		try {
			String sql = "insert into LoaiSanPham(TenLoaiSP) values (?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,lsp.getTenLoaiSP());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public boolean xoaLSP(String ma) {
		try {
			String sql = "delete from LoaiSanPham where MaLoaiSP = ? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ma);
			return preparedStatement.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public int capnhapLSP(LoaiSanPham lsp) {
		try {
			String sql = "update LoaiSanPham set TenLoaiSP = ? where MaLoaiSP = ? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(2, lsp.getMaLoaiSP());
			preparedStatement.setString(1,lsp.getTenLoaiSP());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<LoaiSanPham> tkLSP(String ten){
		ArrayList<LoaiSanPham> arrayList = new ArrayList<LoaiSanPham>();
		try {
			String sql = "SELECT DISTINCT * FROM LoaiSanPham WHERE TenLoaiSP LIKE '%"+ten+"%'";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				LoaiSanPham lsp= new LoaiSanPham();
				lsp.setMaLoaiSP(set.getInt(1));
				lsp.setTenLoaiSP(set.getString(2));
				arrayList.add(lsp);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
}
	public ArrayList<SanPham> docSP(){
		ArrayList<SanPham> arrayList = new ArrayList<SanPham>();
		try {
			String sql = "Select MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSP,NhaSanXuat.TenNSX,GiaBan,GiaNhap,SoLuong from SanPham,LoaiSanPham,NhaSanXuat where SanPham.MaLoaiSP=LoaiSanPham.MaLoaiSP and SanPham.MaNSX = NhaSanXuat.MaNSX";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				SanPham sp= new SanPham();
				sp.setMaSanPham(set.getInt(1));
				sp.setTenSanPham(set.getString(2));
				sp.setMaLoaiSP(set.getString(3));
				sp.setMaNSX(set.getString(4));
				sp.setGiaBan(set.getInt(5));
				sp.setGiaNhap(set.getInt(6));
				sp.setSoLuong(set.getInt(7));
				arrayList.add(sp);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
}
}
