package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.SanPham;
import Entity.SanPham_Sizes;
import Entity.Sizes;
import connectDB.ConnectDB;

public class Sizes_Dao {
	private static final String SELECT_SIZES_BY_MA_SIZE = "SELECT tenSize FROM SizeS WHERE maSize = ?";
	
    public Sizes getSizeById(String maSize) {
    	Sizes size = null;
        Connection con = null;
        con = ConnectDB.getConnection();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_SIZES_BY_MA_SIZE)) {

               preparedStatement.setString(1, maSize);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   
                       String tenSize = resultSet.getString("tenSize");

                       size = new Sizes(maSize, tenSize);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return size;
    }
    
    
}
