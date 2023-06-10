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
import model.NhaSanXuat;
import model.SanPham;

public class NhaSanXuatDAO extends ConnectDatabase{
	public ArrayList<NhaSanXuat> getAllNhaSanXuat(){
		ArrayList<NhaSanXuat> arrayList = new ArrayList<NhaSanXuat>();
		try {
			String sql = "select * from NhaSanXuat";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				NhaSanXuat nsx = new NhaSanXuat();
				nsx.setMaNSX(rs.getInt(1));
				nsx.setTenNSX(rs.getString(2));
				arrayList.add(nsx);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}
	

}
