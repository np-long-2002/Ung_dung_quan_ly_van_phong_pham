package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.HoaDon;
import model.ItemThongKe;

public class HoaDonDAO extends ConnectDatabase{
	public ArrayList<HoaDon> docLS(){
		ArrayList<HoaDon> arrayList = new ArrayList<HoaDon>();
		try {
			String sql = "select MaHoaDon,KhachHang.TenKhachHang,NhanVien.TenNhanVien,NgayLapHoaDon,TongTien,TrangThai from HoaDon,KhachHang,NhanVien where HoaDon.MaKhachHang = KhachHang.MaKhachHang and HoaDon.MaNhanVien = NhanVien.MaNhanVien";
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				HoaDon don = new HoaDon();
				don.setMaHoaDon(set.getInt(1));
				don.setMaKhachHang(set.getString(2));
				don.setMaNhanVien(set.getString(3));
				don.setNgayLapHoaDon(set.getString(4));
				don.setTongTien(set.getInt(5));
				don.setTrangThai(set.getString(6));
				arrayList.add( don);
			}
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}
	
	/*
    SELECT sp.TenSanPham as ten_san_pham, sp.SoLuong as so_luong_ton , SUM(ct.SoLuong) as so_ban, SUM(ct.TongTien) as tong_tien
    FROM HoaDon hd
    JOIN ChiTietHoaDon ct ON hd.MaHoaDon = ct.MaHoaDon
    JOIN SanPham sp ON sp.MaSanPham = ct.MaSanPham
    WHERE YEAR(hd.NgayLapHoaDon) = 2023 AND MONTH(hd.NgayLapHoaDon) = 8
    GROUP BY sp.MaSanPham,sp.TenSanPham,sp.SoLuong;
     */
    public ArrayList<ItemThongKe> getListItemThongKeTheoThang(int month) {
    	ArrayList<ItemThongKe> listItemThongKe = new ArrayList<>();
    	try {
            String sql = "SELECT sp.TenSanPham as ten_san_pham, sp.SoLuong as so_luong_ton , SUM(ct.SoLuong) as so_ban, SUM(ct.TongTien) as tong_tien\n" +
                    "    FROM HoaDon hd\n" +
                    "    JOIN ChiTietHoaDon ct ON hd.MaHoaDon = ct.MaHoaDon\n" +
                    "    JOIN SanPham sp ON sp.MaSanPham = ct.MaSanPham\n" +
                    "    WHERE YEAR(hd.NgayLapHoaDon) = ? AND MONTH(hd.NgayLapHoaDon) = ?\n" +
                    "    GROUP BY sp.MaSanPham,sp.TenSanPham,sp.SoLuong;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,2023);
            stmt.setInt(2,month);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ten_san_pham = rs.getString("ten_san_pham");
                int so_luong_ton = rs.getInt("so_luong_ton");
                int so_ban = rs.getInt("so_ban");
                long tong_tien = rs.getLong("tong_tien");
                listItemThongKe.add(new ItemThongKe(ten_san_pham,so_luong_ton,so_ban,tong_tien));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    	return listItemThongKe;
    }
    /*
    SELECT SUM(ct.so_luong * ct.don_gia) as tong_doanh_thu_thang
	FROM hoa_don hd
	JOIN chi_tiet_hoa_don ct ON hd.ma_hoa_don = ct.ma_hoa_don
	JOIN san_pham sp ON sp.ma_san_pham = ct.ma_san_pham
	WHERE YEAR(hd.ngay_lap) = 2023 AND MONTH(hd.ngay_lap) = 3; 
     */
    public ArrayList<String> getTongDoanhThu12Thang(){
    	ArrayList<String> listDoanhThu = new ArrayList<>();
        try {
        	for(int i = 1 ; i <= 12 ; i++){
	            String sql = "SELECT SUM(ct.TongTien) as tong_doanh_thu_thang\n" +
	                    "FROM HoaDon hd\n" +
	                    "JOIN ChiTietHoaDon ct ON hd.MaHoaDon = ct.MaHoaDon\n" +
	                    "JOIN SanPham sp ON sp.MaSanPham = ct.MaSanPham\n" +
	                    "WHERE YEAR(hd.NgayLapHoaDon) = ? AND MONTH(hd.NgayLapHoaDon) = ?; ";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1,2023);
	            stmt.setInt(2,i);
	
	            ResultSet rs = stmt.executeQuery();
	            long tong_doanh_thu_thang = 0;
	            while(rs.next()){
		            if(rs.getObject("tong_doanh_thu_thang")!=null){
		            	tong_doanh_thu_thang = rs.getLong("tong_doanh_thu_thang");
		            }
	            }
	            listDoanhThu.add(tong_doanh_thu_thang+"");
        	}
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listDoanhThu;
    }
	public boolean addHoaDon(HoaDon hoaDon) {
        try {
            PreparedStatement hoaDonAdd = conn.prepareStatement("INSERT INTO HoaDon ([MaKhachHang],[MaNhanVien]) VALUES(?,?)");
            hoaDonAdd.setString(1, hoaDon.getMaKhachHang());
            hoaDonAdd.setString(2, hoaDon.getMaNhanVien());
            int n = hoaDonAdd.executeUpdate();
            if (n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
	public boolean deleteHoaDon(String maHoaDon) {
		// TODO Auto-generated method stub
        try {
            PreparedStatement stmt = conn.prepareStatement("delete from HoaDon where MaHoaDon = ?");
            stmt.setString(1, maHoaDon);
            int n = stmt.executeUpdate();
            if (n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
		
	

	public boolean updateHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		String sql = "update HoaDon set [MaKhachHang] = ?,[MaNhanVien] = ? Where MaHoaDon = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, hoaDon.getMaKhachHang());
            stmt.setString(2, hoaDon.getMaNhanVien());
            stmt.setInt(3,hoaDon.getMaHoaDon());
            int n = stmt.executeUpdate();
            if (n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean updateTrangThai(HoaDon hoaDon) {
        String sql = "update HoaDon set [TrangThai] = ? Where MaHoaDon = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, hoaDon.getTrangThai());
            stmt.setInt(2, hoaDon.getMaHoaDon());

            int n = stmt.executeUpdate();
            if (n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
		
}
