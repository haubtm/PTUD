package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.SanPham;
import Entity.SanPham_Sizes;
import Entity.Sizes;
import connectDB.ConnectDB;

public class ChiTietHoaDon_Dao {
    public ArrayList<ChiTietHoaDon> getAllChiTietHDByIdHD(String maHD) {
        ArrayList<ChiTietHoaDon> list_ChiTietHD = new ArrayList<ChiTietHoaDon>();
        String sql = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ?";
        Connection con = null;
        con = ConnectDB.getConnection();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(sql)) {

               preparedStatement.setString(1, maHD);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   String maHoaDon = resultSet.getString("maHoaDon");
                	   String maSanPham = resultSet.getString("maSanPham");
                	   int soLuong = resultSet.getInt("soLuong");
                	   String kichThuoc = resultSet.getString("kichThuoc");
                	   Double donGia = resultSet.getDouble("donGia");

                       ChiTietHoaDon cthd = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, kichThuoc, donGia);
                       list_ChiTietHD.add(cthd);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return list_ChiTietHD;
    }
    
	public void addChiTietHD(ChiTietHoaDon cthd) {
        Connection con = null;
        con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into ChiTietHoaDon values(?,?,?,?,?)");
			stmt.setString(1, cthd.getMaHoaDon());
			stmt.setString(2, cthd.getMaSanPham());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setDouble(4, cthd.getDonGia());
			stmt.setString(5, cthd.getKichThuoc());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} finally {
			close(stmt);
		}
	}
    
	public void deleteAllCTHD(String maHD) {
        Connection con = null;
        con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from ChiTietHoaDon where maHoaDon = ?");
			stmt.setString(1, maHD);
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} finally {
			close(stmt);
		}
	}

	private void close(PreparedStatement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
