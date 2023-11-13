package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import Entity.Account;
import Entity.KhachHang;

public class Account_DAO {
	public static void main(String[] args) {
		Account_DAO dao_ac = new Account_DAO();
	    dao_ac.getAllAccount();
	}
	
	public List<Account> getAllAccount(){
		List<Account> ls = new ArrayList<Account>();
		ConnectDB.getConnection();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ls.add(new Account(rs.getString("maTaiKhoan"),rs.getString("taiKhoan"), rs.getString("matKhau"), rs.getString("role"),rs.getString("maNhanVien")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	    public void addAccount(Account account) {	    
	    	Connection con = ConnectDB.getConnection();	        
	    	PreparedStatement stmt = null;
	        try {
	            String sql = "INSERT INTO TaiKhoan (maTaiKhoan, taiKhoan, matKhau, role, maNhanVien) VALUES (?, ?, ?, ?, ?)";        
	        	stmt = con.prepareStatement(sql);
	        	stmt.setString(1, account.getAccountID());
	        	stmt.setString(2, account.getUserName());
	        	stmt.setString(3, account.getPassword());
	        	stmt.setString(4, account.getRole());
	        	stmt.setString(5, account.getMaNV());
	        	stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(stmt);
			}
	    }
	    
	    public void deleteAccountsByMaNhanVien(String maNhanVien) {
	        Connection con = ConnectDB.getConnection();
	        PreparedStatement stmt = null;
	        try {
	            String sql = "DELETE FROM TaiKhoan WHERE maNhanVien = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, maNhanVien);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            close(stmt);
	        }
	    }
	    
	    public void updateAccount(Account ac) {
	        Connection con = ConnectDB.getConnection();
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement("UPDATE TaiKhoan SET taiKhoan = ?, matKhau = ?, role = ? WHERE maTaiKhoan = ?");
	            stmt.setString(1, ac.getUserName());
	            stmt.setString(2, ac.getPassword());
	            stmt.setString(3, ac.getRole());
	            stmt.setString(4, ac.getAccountID());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
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
