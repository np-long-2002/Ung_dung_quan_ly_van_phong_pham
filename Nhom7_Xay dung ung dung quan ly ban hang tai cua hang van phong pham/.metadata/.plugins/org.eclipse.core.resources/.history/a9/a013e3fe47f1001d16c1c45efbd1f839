package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.NguoiDung;

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

}
