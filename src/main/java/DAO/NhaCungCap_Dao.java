package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.NhaCungCap;
import connectDB.ConnectDB;

public class NhaCungCap_Dao {
	private static final String SELECT_NCC_BY_MA_NCC = "SELECT tenNhaCungCap FROM NhaCungCap WHERE maNhaCungCap = ?";
	
    public NhaCungCap getTenNCCByIdNCC(String maNCC) {
    	NhaCungCap ncc = null;
        Connection con = null;
        con = ConnectDB.getConnection();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_NCC_BY_MA_NCC)) {

               preparedStatement.setString(1, maNCC);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   
                       String tenNCC = resultSet.getString("tenNhaCungCap");

                       ncc = new NhaCungCap(maNCC, tenNCC);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return ncc;
    }
}
