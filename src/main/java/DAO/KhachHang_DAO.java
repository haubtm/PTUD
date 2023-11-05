package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entity.KhachHang;
import Entity.LoaiSanPham;
import Entity.NhaCungCap;
import Entity.SanPham;
import connectDB.ConnectDB;

public class KhachHang_DAO {
	public List<KhachHang> getAllKhachHang(){
		
		List<KhachHang> ls = new ArrayList<KhachHang>();
        Connection con = null;
        con = ConnectDB.getConnection();
		try {
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {

				ls.add(new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTen"), rs.getString("soDienThoai"), 
						rs.getBoolean("gioiTinh"), rs.getString("diaChi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	
    public KhachHang getKhachHangById(String maKH) {
    	KhachHang kh = null;
    	String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
        Connection con = null;
        con = ConnectDB.getConnection();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(sql)) {

               preparedStatement.setString(1, maKH);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   String maKhachHang = resultSet.getString("maKhachHang");
                	   String hoTen = resultSet.getString("hoTen");
                	   String soDienThoai = resultSet.getString("soDienThoai");
                	   boolean gioiTinh = resultSet.getBoolean("gioiTinh");
                	   String diaChi = resultSet.getString("diaChi");
                	   
                       kh = new KhachHang(maKhachHang, hoTen, soDienThoai, gioiTinh, diaChi);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return kh;
    }
    
    public KhachHang getKhachHangBySDT(String soDT) {
    	KhachHang kh = null;
    	String sql = "SELECT * FROM KhachHang WHERE soDienThoai = ?";
        Connection con = null;
        con = ConnectDB.getConnection();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(sql)) {

               preparedStatement.setString(1, soDT);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   String maKhachHang = resultSet.getString("maKhachHang");
                	   String hoTen = resultSet.getString("hoTen");
                	   String soDienThoai = resultSet.getString("soDienThoai");
                	   boolean gioiTinh = resultSet.getBoolean("gioiTinh");
                	   String diaChi = resultSet.getString("diaChi");
                	   
                       kh = new KhachHang(maKhachHang, hoTen, soDienThoai, gioiTinh, diaChi);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return kh;
    }
		
		private void close(PreparedStatement stmt) {
			if(stmt != null)
				try {
					stmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void addKhachHang(KhachHang kh) {
	        Connection con = null;
	        con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?)");
				stmt.setString(1, kh.getMaKhachHang());
				stmt.setString(2, kh.getHoTen());
				stmt.setString(3, kh.getSoDienThoai());
				stmt.setBoolean(4, kh.isGioiTinh());
				stmt.setString(5, kh.getDiaChi());
				stmt.executeUpdate();
			} catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			} finally {
				close(stmt);
			}
		}
		
		public void deleteKhachHang(String maKH) {
	        Connection con = null;
	        con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("delete from KhachHang where maKhachHang = ?");
				stmt.setString(1, maKH);		
				stmt.executeUpdate();
			} catch (SQLException ex) {
				// TODO: handle exception
				ex.printStackTrace();
			} finally {
				close(stmt);
			}
		}
		
		public void updateKhachHang(KhachHang kh) {
	        Connection con = null;
	        con = ConnectDB.getConnection();
		    PreparedStatement stmt = null;
		    try {
		    	 stmt = con.prepareStatement("update KhachHang set hoTen = ?, soDienThoai = ?, gioiTinh = ?, diaChi = ? where maKhachHang = ?");
		         stmt.setString(1, kh.getHoTen());
		         stmt.setString(2, kh.getSoDienThoai());
		         stmt.setBoolean(3, kh.isGioiTinh());
		         stmt.setString(4, kh.getDiaChi());
		         stmt.setString(5, kh.getMaKhachHang()); 
		        stmt.executeUpdate();
		    } catch (SQLException ex) {
		        // Xử lý ngoại lệ nếu cần
		        ex.printStackTrace();
		    } finally {
		        close(stmt);
		    }
		}

		
		
}
