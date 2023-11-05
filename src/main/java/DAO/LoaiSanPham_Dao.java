package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.LoaiSanPham;
import Entity.NhaCungCap;
import connectDB.ConnectDB;

public class LoaiSanPham_Dao {
	private static final String SELECT_LOAISP_BY_MA_LOAISP = "SELECT tenLoaiSanPham FROM LoaiSanPham WHERE maLoaiSanPham = ?";
	
    public LoaiSanPham getTenLoaiSPById(String maLoaiSP) {
    	LoaiSanPham lsp = null;
        Connection con = null;
        con = ConnectDB.getConnection();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_LOAISP_BY_MA_LOAISP)) {

               preparedStatement.setString(1, maLoaiSP);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   
                       String tenLoaiSP = resultSet.getString("tenLoaiSanPham");

                       lsp = new LoaiSanPham(maLoaiSP, tenLoaiSP);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return lsp;
    }
}
