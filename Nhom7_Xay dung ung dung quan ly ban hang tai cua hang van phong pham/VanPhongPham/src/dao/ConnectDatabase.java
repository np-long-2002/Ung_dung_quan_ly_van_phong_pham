package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	protected Connection conn =null;
	public ConnectDatabase() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlyvanphongpham;integratedSecurity=true;trustServerCertificate=true;");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

//String url = "jdbc:sqlserver://localhost:1433;databaseName=quanlyvanphongpham;user=sa;password=sapassword;";
//conn = DriverManager.getConnection(url);
