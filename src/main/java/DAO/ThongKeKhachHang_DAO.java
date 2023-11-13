package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

import ConnectDatabase.database;
import Entity.DataThongKeKHTheoNam;
import Entity.DataThongKeKHTheoNgay;
import Entity.DataThongKeKHTheoThang;
import Entity.DataThongKeNhanVien;
import Entity.DataThongKeNhanVienNam;
import Entity.DataThongKeNhanVienThang;
import Entity.HoaDon;
import Entity.KhachHang;

public class ThongKeKhachHang_DAO {
	
	 public DataThongKeKHTheoNgay  getKhachHangNhieuHoaDonNhatTheoNgay(int nam, int thang, int ngay,int tongSoHoaDon,int soLuong) {
	        List<KhachHang> danhSachKhachHang = new ArrayList<>();
	    	List<Integer> danhSachSoHoaDon = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        try {
	            connection = database.getConnection();
	            String sql = "SELECT TOP (?)  maKhachHang, COUNT(maHoaDon) AS soHoaDon "
	                    + "FROM HoaDon "
	                    + "WHERE YEAR(ngayLapHoaDon) = ? AND MONTH(ngayLapHoaDon) = ? AND DAY(ngayLapHoaDon) = ? "
	                    + " GROUP BY maKhachHang "
	                    + " ORDER BY soHoaDon DESC";
	            statement = connection.prepareStatement(sql);
	            statement.setInt(1, soLuong);
	            statement.setInt(2, nam);
	            statement.setInt(3, thang);
	            statement.setInt(4, ngay);
	            
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                KhachHang khachHang = new KhachHang();
	                khachHang.setMaKhachHang(resultSet.getString("maKhachHang"));
	                danhSachKhachHang.add(khachHang);
	                int soLuongHoaDon = resultSet.getInt("soHoaDon");
	                tongSoHoaDon += soLuongHoaDon;
	                danhSachSoHoaDon.add(soLuongHoaDon);
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            close(statement);
	        }
	        return new DataThongKeKHTheoNgay(danhSachKhachHang, tongSoHoaDon,danhSachSoHoaDon);
	    }
	
	
    
    public DataThongKeKHTheoThang getKhachHangNhieuHoaDonNhatTheoThang(int nam, int thang,int tongSoHoaDon,int soLuong) {
        List<KhachHang> danhSachKhachHang = new ArrayList<>();
    	List<Integer> danhSachSoHoaDon = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT TOP (?)  maKhachHang, COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLapHoaDon) = ? AND MONTH(ngayLapHoaDon) = ? "
                    + " GROUP BY maKhachHang "
                    + "ORDER BY soHoaDon DESC";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, soLuong);
            statement.setInt(2, nam);
            statement.setInt(3, thang);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKhachHang(resultSet.getString("maKhachHang"));
                danhSachKhachHang.add(khachHang);
                int soLuongHoaDon = resultSet.getInt("soHoaDon");
                danhSachSoHoaDon.add(soLuongHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return new DataThongKeKHTheoThang(danhSachKhachHang, tongSoHoaDon,danhSachSoHoaDon);
    }
    
    
    public DataThongKeKHTheoNam getSoLuongHoaDonKhachHangTheoNam( int nam,int tongSoHoaDon,int soLuong) {
    	List<KhachHang> danhSachKhachHang = new ArrayList<>();
    	List<Integer> danhSachSoHoaDon = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	connection = database.getConnection();
        	String sql = "SELECT TOP (?) maKhachHang, COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLapHoaDon) = ? "
                    + "GROUP BY maKhachHang "
                    + "ORDER BY soHoaDon DESC";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, soLuong);
            statement.setInt(2, nam);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKhachHang(resultSet.getString("maKhachHang"));
                danhSachKhachHang.add(khachHang);
                int soLuongHoaDon = resultSet.getInt("soHoaDon");
                danhSachSoHoaDon.add(soLuongHoaDon);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return new DataThongKeKHTheoNam(danhSachKhachHang, tongSoHoaDon,danhSachSoHoaDon);
    }
    
    
    public String getTenKhachHangFromMaKhachHang(String maKhachHang) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String hoTen = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT hoTen FROM KhachHang WHERE maKhachHang = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maKhachHang);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                hoTen = resultSet.getString("hoTen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return hoTen;
    }
    

    
    public List<KhachHang> getDanhSachKhachHang() {
        List<KhachHang> danSachKhachHang = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT * FROM KhachHang"; 
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                KhachHang khachHang = new KhachHang();
                // Đọc thông tin nhân viên từ resultSet và thiết lập các thuộc tính của đối tượng NhanVien
                khachHang.setMaKhachHang(resultSet.getString("maNhanVien"));
                danSachKhachHang.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return danSachKhachHang;
    }
    
    
	private void close(PreparedStatement stmt) {
		if(stmt != null)
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
