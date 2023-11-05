package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.SanPham;
import Entity.SanPham_Sizes;
import Entity.Sizes;
import connectDB.ConnectDB;

public class SanPham_SizeS_Dao {
	private static final String SELECT_SIZES_BY_MA_SANPHAM = "SELECT * FROM SanPham_SizeS WHERE maSanPham = ?";
	
    public ArrayList<SanPham_Sizes> getAllSanPham_SizesByIdSP(String maSP) {
        ArrayList<SanPham_Sizes> list_spSize = new ArrayList<>();
        Connection con = null;
        con = ConnectDB.getConnection();
        Sizes_Dao size_dao = new Sizes_Dao();
        SanPham_Dao sp_dao = new SanPham_Dao();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_SIZES_BY_MA_SANPHAM)) {

               preparedStatement.setString(1, maSP);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   
                       int soLuong = resultSet.getInt("soLuong");
                       Sizes size = size_dao.getSizeById(resultSet.getString("maSize"));
                       SanPham sp = sp_dao.getSanPhamById(resultSet.getString("maSanPham").trim());

                       SanPham_Sizes sps = new SanPham_Sizes(size, sp, soLuong);
                       list_spSize.add(sps);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return list_spSize;
    }
    
	public void updateSoLuongSize(int soLuongCon, String maSanPham, String maSize) {
        Connection con = null;
        con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("update SanPham_SizeS set soLuong = ? where maSize = ? and maSanPham = ?");
			
			stmt.setInt(1, soLuongCon);
			stmt.setString(2, maSize);
			stmt.setString(3, maSanPham);
			
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
