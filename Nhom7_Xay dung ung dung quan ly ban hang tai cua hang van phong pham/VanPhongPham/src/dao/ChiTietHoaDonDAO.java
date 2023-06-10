package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ChiTietHoaDon;
import model.HoaDon;

public class ChiTietHoaDonDAO extends ConnectDatabase{
	public ArrayList<ChiTietHoaDon> docLS(){
		ArrayList<ChiTietHoaDon> arrayList = new ArrayList<ChiTietHoaDon>();
		try {
			String sql = "Select * from ChiTietHoaDon ";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				ChiTietHoaDon don = new ChiTietHoaDon();
				don.setMaChiTietHD(set.getInt(1));
				don.setMaHoaDon(set.getInt(2));
				don.setMaSanPham(set.getInt(3));
				don.setSoLuong(set.getInt(4));
				don.setTongTien(set.getInt(5));
				arrayList.add( don);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public boolean addCTHoaDon(ChiTietHoaDon chiTiet) {
        try {
            PreparedStatement cthdAdd = conn.prepareStatement("INSERT INTO ChiTietHoaDon ([MaHoaDon],[MaSanPham],[SoLuong]) VALUES(?,?,?)");
            cthdAdd.setString(1,String.valueOf(chiTiet.getMaHoaDon()));
            cthdAdd.setString(2,String.valueOf( chiTiet.getMaSanPham()));
            cthdAdd.setString(3, String.valueOf(chiTiet.getSoLuong()));
            int n = cthdAdd.executeUpdate();
            if (n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteCTHoaDon(String maCTHoaDon) {
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from ChiTietHoaDon where MaChiTietHD = ?");
            stmt.setString(1, maCTHoaDon);
            int n = stmt.executeUpdate();
            if (n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateCTHoaDon(ChiTietHoaDon chiTiet) {
        String sql = "update ChiTietHoaDon set [SoLuong] = ? Where MaChiTietHD = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chiTiet.getSoLuong());
            stmt.setInt(2, chiTiet.getMaChiTietHD());

            int n = stmt.executeUpdate();
            if (n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	
}

