package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.KhachHang;
import model.LoaiKhachHang;

public class KhachHangDAO extends ConnectDatabase{
	public ArrayList<KhachHang> docLS(){
		ArrayList<KhachHang> arrayList = new ArrayList<KhachHang>();
		try {
			String sql = "Select MaKhachHang,TenKhachHang,GioiTinh,SoDienThoai,LoaiKhachHang.TenLoaiKH from KhachHang,LoaiKhachHang where KhachHang.MaLoaiKH = LoaiKhachHang.MaLoaiKH";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(set.getInt(1));
				kh.setTenKhachHang(set.getString(2));
				kh.setGioiTinh(set.getString(3));
				kh.setSoDienThoai(set.getString(4));
				kh.setMaLoaiKH(set.getString(5));
				arrayList.add(kh);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
}
	public ArrayList<LoaiKhachHang>doc(){
		ArrayList<LoaiKhachHang> arrayList = new ArrayList<LoaiKhachHang>();
		try {
			String sql = "Select * from LoaiKhachHang";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				LoaiKhachHang kh = new LoaiKhachHang();
				kh.setMaLoaiKH(set.getInt(1));
				kh.setTenLoaiKH(set.getString(2));
				arrayList.add(kh);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
}
	public int luuKH(KhachHang kh) {
		try {
			String sql = "insert into KhachHang(TenKhachHang,GioiTinh ,SoDienThoai,MaLoaiKH) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,kh.getTenKhachHang());
			preparedStatement.setString(2,kh.getGioiTinh());
			preparedStatement.setString(3,kh.getSoDienThoai());
			preparedStatement.setString(4,kh.getMaLoaiKH());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public boolean xoaKH(String ma) {
		try {
			String sql = "delete from KhachHang where MaKhachHang = ? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, ma);
			return preparedStatement.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public int capnhapKH(KhachHang kh) {
		try {
			String sql = "update KhachHang set TenKhachHang = ? , GioiTinh = ? , SoDienThoai = ?,MaLoaiKH = ? where MaKhachHang = ? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(5, kh.getMaKhachHang());
			preparedStatement.setString(1,kh.getTenKhachHang());
			preparedStatement.setString(2, kh.getGioiTinh());
			preparedStatement.setString(3, kh.getSoDienThoai());
			preparedStatement.setString(4, kh.getMaLoaiKH());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<KhachHang> tkKH(String ten){
		ArrayList<KhachHang> arrayList = new ArrayList<KhachHang>();
		try {
			String sql = "SELECT DISTINCT MaKhachHang,TenKhachHang,GioiTinh,SoDienThoai,LoaiKhachHang.TenLoaiKH FROM KhachHang,LoaiKhachHang WHERE KhachHang.MaLoaiKH = LoaiKhachHang.MaLoaiKH and TenKhachHang LIKE '%"+ten+"%'";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
					KhachHang kh = new KhachHang();
					kh.setMaKhachHang(set.getInt(1));
					kh.setTenKhachHang(set.getString(2));
					kh.setGioiTinh(set.getString(3));
					kh.setSoDienThoai(set.getString(4));
			kh.setMaLoaiKH(set.getString(5));
				arrayList.add(kh);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return arrayList;
}
}
