package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import connectDB.ConnectDB;

public class HoaDon_Dao {
    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> list_hd = new ArrayList<HoaDon>();
        
        Connection con = null;
        con = ConnectDB.getConnection();
        KhachHang_DAO kh_dao = new KhachHang_DAO();
        NhanVien_DAO nv_dao = new NhanVien_DAO();
        try (Statement stmt = ConnectDB.getConnection().createStatement()) {
            String sql = "Select * from HoaDon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	String maHD = rs.getString("maHoaDon");
                Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                float thue = rs.getFloat("thue");
                KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
                NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
                 
                HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
                list_hd.add(hd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_hd;
    }
    
    public ArrayList<HoaDon> getAllHoaDonByMonthAndYear(int month, int year) {
        ArrayList<HoaDon> list_hd = new ArrayList<HoaDon>();
        
        Connection con = null;
        con = ConnectDB.getConnection();
        KhachHang_DAO kh_dao = new KhachHang_DAO();
        NhanVien_DAO nv_dao = new NhanVien_DAO();
        try (Statement stmt = ConnectDB.getConnection().createStatement()) {
            String sql = "Select * from HoaDon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                if(ngayLapHoaDon.getYear() + 1900 == year && ngayLapHoaDon.getMonth() + 1 == month) {
                	String maHD = rs.getString("maHoaDon");
                    float thue = rs.getFloat("thue");
                    KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
                    NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
                    HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
                    list_hd.add(hd);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_hd;
    }
    
    public ArrayList<HoaDon> getAllHoaDonByQuarterAndYear(int quarter, int year) {
        ArrayList<HoaDon> list_hd = new ArrayList<HoaDon>();
        
        Connection con = null;
        con = ConnectDB.getConnection();
        KhachHang_DAO kh_dao = new KhachHang_DAO();
        NhanVien_DAO nv_dao = new NhanVien_DAO();
        try (Statement stmt = ConnectDB.getConnection().createStatement()) {
            String sql = "Select * from HoaDon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
            	switch (quarter) {
				case 1:
	                if(ngayLapHoaDon.getYear() + 1900 == year && (ngayLapHoaDon.getMonth() + 1 >= 1 && ngayLapHoaDon.getMonth() + 1 <= 3)) {
	                	String maHD = rs.getString("maHoaDon");
	                    float thue = rs.getFloat("thue");
	                    KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
	                    NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
	                    HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
	                    list_hd.add(hd);
	                }
					break;
				case 2:
	                if(ngayLapHoaDon.getYear() + 1900 == year && (ngayLapHoaDon.getMonth() + 1 >= 4 && ngayLapHoaDon.getMonth() + 1 <= 6) ) {
	                	String maHD = rs.getString("maHoaDon");
	                    float thue = rs.getFloat("thue");
	                    KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
	                    NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
	                    HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
	                    list_hd.add(hd);
	                }
	                break;
				case 3:
	                if(ngayLapHoaDon.getYear() + 1900 == year && (ngayLapHoaDon.getMonth() + 1 >= 7 && ngayLapHoaDon.getMonth() + 1 <= 9)) {
	                	String maHD = rs.getString("maHoaDon");
	                    float thue = rs.getFloat("thue");
	                    KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
	                    NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
	                    HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
	                    list_hd.add(hd);
	                }
	                break;
				case 4:
	                if(ngayLapHoaDon.getYear() + 1900 == year && (ngayLapHoaDon.getMonth() + 1 >= 10 && ngayLapHoaDon.getMonth() + 1 <= 12)) {
	                	String maHD = rs.getString("maHoaDon");
	                    float thue = rs.getFloat("thue");
	                    KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
	                    NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
	                    HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
	                    list_hd.add(hd);
	                }
	                break;
				default:
					break;
				}

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_hd;
    }
    
    public ArrayList<HoaDon> getAllHoaDonByYear(int year) {
        ArrayList<HoaDon> list_hd = new ArrayList<HoaDon>();
        
        Connection con = null;
        con = ConnectDB.getConnection();
        KhachHang_DAO kh_dao = new KhachHang_DAO();
        NhanVien_DAO nv_dao = new NhanVien_DAO();
        try (Statement stmt = ConnectDB.getConnection().createStatement()) {
            String sql = "Select * from HoaDon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                if(ngayLapHoaDon.getYear() + 1900 == year) {
                	String maHD = rs.getString("maHoaDon");
                    float thue = rs.getFloat("thue");
                    KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
                    NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
                    HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
                    list_hd.add(hd);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_hd;
    }
    
    public ArrayList<HoaDon> getAllHoaDonByDate(java.util.Date date) {
        ArrayList<HoaDon> list_hd = new ArrayList<HoaDon>();
        
        Connection con = null;
        con = ConnectDB.getConnection();
        KhachHang_DAO kh_dao = new KhachHang_DAO();
        NhanVien_DAO nv_dao = new NhanVien_DAO();
        try (Statement stmt = ConnectDB.getConnection().createStatement()) {
            String sql = "Select * from HoaDon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                if(ngayLapHoaDon.getYear() == date.getYear() && ngayLapHoaDon.getMonth() == date.getMonth() && ngayLapHoaDon.getDay() == date.getDay()) {
                	String maHD = rs.getString("maHoaDon");
                    float thue = rs.getFloat("thue");
                    KhachHang kh = kh_dao.getKhachHangById(rs.getString("maKhachHang"));
                    NhanVien nv = nv_dao.getNhanVienById(rs.getString("maNhanVien"));
                    HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, thue, kh, nv);
                    list_hd.add(hd);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_hd;
    }
    
    public Double getTongTienHDByIdHD(String maHD) {
    	Double tongTien = 0.0;
        ChiTietHoaDon_Dao cthd_dao = new ChiTietHoaDon_Dao();
        
        for (ChiTietHoaDon cthd : cthd_dao.getAllChiTietHDByIdHD(maHD)) {

			String tongTienStr = String.format("%.0f", (cthd.getDonGia()*0.1 + cthd.getDonGia()) * cthd.getSoLuong() );
			tongTien += Double.parseDouble(tongTienStr);
			
		}
        return tongTien;
    }
    
	public void addHoaDon(HoaDon hd) {
        Connection con = null;
        con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into HoaDon values(?,?,?,?,?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setDate(2, new java.sql.Date(hd.getNgayLapHoaDon().getTime()));
			stmt.setDouble(3, 0.1);
			stmt.setString(4, hd.getKhachHang().getMaKhachHang());
			stmt.setString(5, hd.getNhanVien().getMaNhanVien());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} finally {
			close(stmt);
		}
	}
    
	public void deleteHoaDon(String maHD) {
        Connection con = null;
        con = ConnectDB.getConnection();
        ChiTietHoaDon_Dao cthd_dao = new ChiTietHoaDon_Dao();
        cthd_dao.deleteAllCTHD(maHD);
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from HoaDon where maHoaDon = ?");
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
