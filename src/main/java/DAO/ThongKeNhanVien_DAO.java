package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ConnectDatabase.database;
import Entity.DataThongKeNhanVien;
import Entity.DataThongKeNhanVienNam;
import Entity.DataThongKeNhanVienThang;
import Entity.HoaDon;
import Entity.NhanVien;

public class ThongKeNhanVien_DAO {
    
    public DataThongKeNhanVienThang getNhanVienNhieuHoaDonNhatTheoThang(int nam, int thang,int tongSoHoaDon,int soLuong) {
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
    	List<Integer> danhSachSoHoaDon = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT TOP (?) maNhanVien, COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLapHoaDon) = ? AND MONTH(ngayLapHoaDon) = ? "
                    + "GROUP BY maNhanVien "
                    + "ORDER BY soHoaDon DESC";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, soLuong);
            statement.setInt(2, nam);
            statement.setInt(3, thang);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
                danhSachNhanVien.add(nhanVien);
                int soLuongHoaDon = resultSet.getInt("soHoaDon");
                tongSoHoaDon += soLuongHoaDon; 
                danhSachSoHoaDon.add(soLuongHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return new DataThongKeNhanVienThang(danhSachNhanVien, tongSoHoaDon,danhSachSoHoaDon);
    }
    
    public DataThongKeNhanVien  getNhanVienNhieuHoaDonNhatTheoNgay(int nam, int thang, int ngay,int tongSoHoaDon,int soLuong) {
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
    	List<Integer> danhSachSoHoaDon = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = database.getConnection();
            String sql = "SELECT TOP (?) maNhanVien, COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLapHoaDon) = ? AND MONTH(ngayLapHoaDon) = ? AND DAY(ngayLapHoaDon) = ? "
                    + "GROUP BY maNhanVien "
                    + "ORDER BY soHoaDon DESC";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, soLuong);
            statement.setInt(2, nam);
            statement.setInt(3, thang);
            statement.setInt(4, ngay);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
                danhSachNhanVien.add(nhanVien);
                int soLuongHoaDon = resultSet.getInt("soHoaDon");
                tongSoHoaDon += soLuongHoaDon; 
                danhSachSoHoaDon.add(soLuongHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }
        return new DataThongKeNhanVien(danhSachNhanVien, tongSoHoaDon,danhSachSoHoaDon);
    }
    
    public DataThongKeNhanVienNam getSoLuongHoaDonTheoNam( int nam,int tongSoHoaDon,int soLuong) {
    	List<NhanVien> danhSachNhanVien = new ArrayList<>();
    	List<Integer> danhSachSoHoaDon = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	connection = database.getConnection();
        	String sql = "SELECT TOP (?) maNhanVien, COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLapHoaDon) = ? "
                    + "GROUP BY maNhanVien "
                    + "ORDER BY soHoaDon DESC";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, soLuong);
            statement.setInt(2, nam);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
                danhSachNhanVien.add(nhanVien);
                int soLuongHoaDon = resultSet.getInt("soHoaDon");
                tongSoHoaDon = soLuongHoaDon; 
                danhSachSoHoaDon.add(soLuongHoaDon);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return new DataThongKeNhanVienNam(danhSachNhanVien, tongSoHoaDon,danhSachSoHoaDon);
    }
    
    public int getSoLuongHoaDonTheoNam1(String maNhanVien, int nam) {
        int soLuongHoaDon = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE maNhanVien = ? AND YEAR(ngayLapHoaDon) = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maNhanVien);
            statement.setInt(2, nam);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                soLuongHoaDon = resultSet.getInt("soHoaDon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return soLuongHoaDon;
    }

    
    
    public String getTenNhanVienFromMaNhanVien(String maNhanVien) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String hoTen = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT hoTen FROM NhanVien WHERE maNhanVien = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maNhanVien);
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
    

    
    public List<NhanVien> getDanhSachNhanVien() {
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT * FROM NhanVien"; // Thay thế bằng truy vấn SQL thích hợp
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                // Đọc thông tin nhân viên từ resultSet và thiết lập các thuộc tính của đối tượng NhanVien
                nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
                danhSachNhanVien.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return danhSachNhanVien;
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
