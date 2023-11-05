package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.LoaiSanPham;
import Entity.NhaCungCap;
import Entity.SanPham;
import Entity.SanPham_Sizes;
import Entity.Sizes;
import connectDB.ConnectDB;

public class SanPham_Dao {
    public SanPham_Dao() {}
    
    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list_sp = new ArrayList<SanPham>();

        Connection con = null;
        con = ConnectDB.getConnection();
        NhaCungCap_Dao ncc_dao = new NhaCungCap_Dao();
        LoaiSanPham_Dao lsp_dao = new LoaiSanPham_Dao();
        try (Statement stmt = ConnectDB.getConnection().createStatement()) {
            String sql = "SELECT * FROM SanPham";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String ma = rs.getString("maSanPham").trim();
                String ten = rs.getString("tenSanPham").trim();
                Double giaNhap = rs.getDouble("giaNhap");
                Double giaBan = rs.getDouble("giaBan");
                String mauSac = rs.getString("mauSac");
                String xuatXu = rs.getString("xuatXu");
                String moTa = rs.getString("moTa");
                String hinhAnh = rs.getString("hinhAnh");
                NhaCungCap ncc = ncc_dao.getTenNCCByIdNCC(rs.getString("maNhaCungCap"));
                LoaiSanPham loaiSanPham = lsp_dao.getTenLoaiSPById(rs.getString("maLoaiSanPham"));
                
                SanPham sp = new SanPham(ma, ten, giaNhap, giaBan, mauSac, xuatXu, moTa, hinhAnh, loaiSanPham, ncc);
                 
                list_sp.add(sp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list_sp;
    }
    
	private static final String SELECT_SP_BY_MA_SANPHAM = "SELECT * FROM SanPham WHERE maSanPham = ?";
    
    public SanPham getSanPhamById(String maSP) {
    	SanPham sp = null;
        Connection con = null;
        con = ConnectDB.getConnection();
        NhaCungCap_Dao ncc_dao = new NhaCungCap_Dao();
        LoaiSanPham_Dao lsp_dao = new LoaiSanPham_Dao();
        try (
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_SP_BY_MA_SANPHAM)) {

               preparedStatement.setString(1, maSP);

               try (ResultSet resultSet = preparedStatement.executeQuery()) {
                   while (resultSet.next()) {
                	   
                       String tenSP = resultSet.getString("tenSanPham");
                       Double giaNhap = resultSet.getDouble("giaNhap");
                       Double giaBan = resultSet.getDouble("giaBan");
                       String mauSac = resultSet.getString("mauSac");
                       String xuatXu = resultSet.getString("xuatXu");
                       String moTa = resultSet.getString("moTa");
                       String hinhAnh = resultSet.getString("hinhAnh");
                       LoaiSanPham LoaiSP = lsp_dao.getTenLoaiSPById(resultSet.getString("maLoaiSanPham"));
                       NhaCungCap nCC = ncc_dao.getTenNCCByIdNCC(resultSet.getString("maNhaCungCap"));

                       sp = new SanPham(maSP, tenSP, giaNhap, giaBan, mauSac, xuatXu, moTa, hinhAnh, LoaiSP, nCC);
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return sp;
    }
    


//    public boolean themSanPhamVaSize(SanPham them, SanPham_Sizes them1) {
//        Connection con = null;
//        int n = 0;
//
//        try {
//            con = ConnectDB.getConnection();
//
//            if (con != null) {
//                con.setAutoCommit(false); // Tắt chế độ tự động commit
//
//                String sql_sp = "INSERT INTO SanPham (maSanPham, tenSanPham, giaNhap, giaBan, mauSac, xuatXu, moTa, hinhAnh, maLoaiSanPham, maNhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//                String sql_sizeS = "INSERT INTO SanPham_SizeS (maSize, maSanPham, soLuong) VALUES (?, ?, ?)";
//
//                try (PreparedStatement stmt_SP = con.prepareStatement(sql_sp);
//                     PreparedStatement stmt_SizeS = con.prepareStatement(sql_sizeS)) {
//
//                    stmt_SP.setString(1, them.getMaSanPham());
//                    stmt_SP.setString(2, them.getTenSanPham());
//                    stmt_SP.setDouble(3, them.getGiaNhap());
//                    stmt_SP.setDouble(4, them.getGiaBan());
//                    stmt_SP.setString(5, them.getMauSac());
//                    stmt_SP.setString(6, them.getXuatXu());
//                    stmt_SP.setString(7, them.getMoTa());
//                    stmt_SP.setString(8, them.getHinhAnh());
//                    stmt_SP.setString(9, them.getLoaiSanPham().getMaLoaiSanPham());
//                    stmt_SP.setString(10, them.getNhaCungCap().getMaNhaCungCap());
//                    int m = stmt_SP.executeUpdate(); // Thêm sản phẩm
//
//                    if (m > 0) {
//                        stmt_SizeS.setString(1, them1.getSizes().getMaSize());
//                        stmt_SizeS.setString(2, them1.getSanPham().getMaSanPham());
//                        stmt_SizeS.setInt(3, them1.getSoLuong());
//                        int k = stmt_SizeS.executeUpdate(); // Thêm số lượng của size
//
//                        if (k > 0) {
//                            con.commit(); // Commit giao dịch nếu cả hai câu truy vấn đều thành công
//                        } else {
//                            con.rollback(); // Nếu thêm số lượng của size thất bại, thực hiện rollback
//                        }
//                    }
//                }
//            } else {
//                System.out.println("Kết nối là null. Hãy đảm bảo rằng kết nối cơ sở dữ liệu của bạn đã được thiết lập đúng cách.");
//            }
//        } catch (SQLException e) {
//            try {
//                if (con != null) {
//                    con.rollback(); // Nếu xảy ra lỗi, thực hiện rollback để không thay đổi cơ sở dữ liệu
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            e.printStackTrace();
//        } finally {
//            try {
//                if (con != null) {
//                    con.setAutoCommit(true); // Bật chế độ tự động commit trở lại
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return n > 0;
//    }
    public boolean themSanPhamVaSize(SanPham them, SanPham_Sizes them1) {
        Connection con = null;
        int n = 0;

        try {
            con = ConnectDB.getConnection();

            if (con != null) {
                con.setAutoCommit(false); // Tắt chế độ tự động commit

                String sql_sp = "INSERT INTO SanPham (maSanPham, tenSanPham, giaNhap, giaBan, mauSac, xuatXu, moTa, hinhAnh, maLoaiSanPham, maNhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                String sql_sizeS = "INSERT INTO SanPham_SizeS (maSize, maSanPham, soLuong) VALUES (?, ?, ?)";
                String sql_checkExist = "SELECT COUNT(*) FROM SanPham_SizeS WHERE maSize = ? AND maSanPham = ?";

                try (PreparedStatement stmt_SP = con.prepareStatement(sql_sp);
                     PreparedStatement stmt_SizeS = con.prepareStatement(sql_sizeS);
                     PreparedStatement stmt_CheckExist = con.prepareStatement(sql_checkExist)) {

                    con.setAutoCommit(false);

                  stmt_SP.setString(1, them.getMaSanPham());
                  stmt_SP.setString(2, them.getTenSanPham());
                  stmt_SP.setDouble(3, them.getGiaNhap());
                  stmt_SP.setDouble(4, them.getGiaBan());
                  stmt_SP.setString(5, them.getMauSac());
                  stmt_SP.setString(6, them.getXuatXu());
                  stmt_SP.setString(7, them.getMoTa());
                  stmt_SP.setString(8, them.getHinhAnh());
                  stmt_SP.setString(9, them.getLoaiSanPham().getMaLoaiSanPham());
                  stmt_SP.setString(10, them.getNhaCungCap().getMaNhaCungCap());

                    int m = stmt_SP.executeUpdate(); // Thêm sản phẩm

                    if (m > 0) {
                        stmt_SizeS.setString(1, them1.getSizes().getMaSize());
                        stmt_SizeS.setString(2, them1.getSanPham().getMaSanPham());
                        stmt_SizeS.setInt(3, them1.getSoLuong());

                        // Kiểm tra sự tồn tại của dữ liệu trong bảng SanPham_SizeS trước khi thêm
                        stmt_CheckExist.setString(1, them1.getSizes().getMaSize());
                        stmt_CheckExist.setString(2, them1.getSanPham().getMaSanPham());
                        ResultSet rs = stmt_CheckExist.executeQuery();
                        rs.next();
                        int rowCount = rs.getInt(1);

                        if (rowCount == 0) {
                            int k = stmt_SizeS.executeUpdate(); // Thêm số lượng của size

                            if (k > 0) {
                                con.commit(); // Commit giao dịch nếu cả hai câu truy vấn đều thành công
                            } else {
                                con.rollback(); // Nếu thêm số lượng của size thất bại, thực hiện rollback
                            }
                        } else {
                            // Dữ liệu đã tồn tại, không thực hiện thêm
                            con.rollback();
                        }
                    }
                }
            } else {
                System.out.println("Kết nối là null. Hãy đảm bảo rằng kết nối cơ sở dữ liệu của bạn đã được thiết lập đúng cách.");
            }
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // Nếu xảy ra lỗi, thực hiện rollback để không thay đổi cơ sở dữ liệu
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true); // Bật chế độ tự động commit trở lại
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return n > 0;
    }
    
    public boolean themSanPham(SanPham them) {
        Connection con = null;
        int n = 0;

        try {
            con = ConnectDB.getConnection();

            if (con != null) {
                con.setAutoCommit(false); // Tắt chế độ tự động commit

                String sql_sp = "INSERT INTO SanPham (maSanPham, tenSanPham, giaNhap, giaBan, mauSac, xuatXu, moTa, hinhAnh, maLoaiSanPham, maNhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement stmt_SP = con.prepareStatement(sql_sp)) {
                    stmt_SP.setString(1, them.getMaSanPham());
                    stmt_SP.setString(2, them.getTenSanPham());
                    stmt_SP.setDouble(3, them.getGiaNhap());
                    stmt_SP.setDouble(4, them.getGiaBan());
                    stmt_SP.setString(5, them.getMauSac());
                    stmt_SP.setString(6, them.getXuatXu());
                    stmt_SP.setString(7, them.getMoTa());
                    stmt_SP.setString(8, them.getHinhAnh());
                    stmt_SP.setString(9, them.getLoaiSanPham().getMaLoaiSanPham());
                    stmt_SP.setString(10, them.getNhaCungCap().getMaNhaCungCap());

                    int m = stmt_SP.executeUpdate(); // Thêm sản phẩm

                    if (m > 0) {
                        con.commit(); // Commit giao dịch nếu câu truy vấn thành công
                    } else {
                        con.rollback(); // Nếu thêm sản phẩm thất bại, thực hiện rollback
                    }
                }
            } else {
                System.out.println("Kết nối là null. Hãy đảm bảo rằng kết nối cơ sở dữ liệu của bạn đã được thiết lập đúng cách.");
            }
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // Nếu xảy ra lỗi, thực hiện rollback để không thay đổi cơ sở dữ liệu
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true); // Bật chế độ tự động commit trở lại
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return n > 0;
    }

    public boolean themSoLuongSizeVaoDB(String maSanPham, String maSize, int soLuong) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean themThanhCong = false;

        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                // Kiểm tra xem đã tồn tại bản ghi với mã sản phẩm và mã size tương tự chưa
                String checkSQL = "SELECT COUNT(*) FROM SanPham_SizeS WHERE maSize = ? AND maSanPham = ?";
                PreparedStatement checkStmt = con.prepareStatement(checkSQL);
                checkStmt.setString(1, maSize);
                checkStmt.setString(2, maSanPham);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    if (count == 0) {
                        // Nếu không có bản ghi nào trùng lặp, thêm mới vào cơ sở dữ liệu
                        String insertSQL = "INSERT INTO SanPham_SizeS (maSize, maSanPham, soLuong) VALUES (?, ?, ?)";
                        stmt = con.prepareStatement(insertSQL);
                        stmt.setString(1, maSize);
                        stmt.setString(2, maSanPham);
                        stmt.setInt(3, soLuong);

                        int rowsAffected = stmt.executeUpdate();
                        if (rowsAffected > 0) {
                            themThanhCong = true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return themThanhCong;
    }

    public boolean xoaSanPham(String maSanPham) {
        Connection con = null;

        try {
            con = ConnectDB.getConnection();

            if (con != null) {
                con.setAutoCommit(false); // Tắt chế độ tự động commit

                String sqlSanPhamSizes = "DELETE FROM SanPham_SizeS WHERE maSanPham = ?";
                String sqlSanPham = "DELETE FROM SanPham WHERE maSanPham = ?";
                
                try (PreparedStatement stmtSanPhamSizes = con.prepareStatement(sqlSanPhamSizes);
                     PreparedStatement stmtSanPham = con.prepareStatement(sqlSanPham)) {
                    stmtSanPhamSizes.setString(1, maSanPham);
                    stmtSanPham.setString(1, maSanPham);
                    
                    int resultSanPhamSizes = stmtSanPhamSizes.executeUpdate(); // Xóa từ bảng SanPham_Sizes
                    int resultSanPham = stmtSanPham.executeUpdate(); // Xóa từ bảng SanPham
                    
                    if (resultSanPhamSizes > 0 && resultSanPham > 0) {
                        con.commit(); // Commit giao dịch nếu cả hai câu lệnh xóa đều thành công
                        return true;
                    } else {
                        con.rollback(); // Nếu xóa không thành công, thực hiện rollback
                    }
                }
            } else {
                System.out.println("Kết nối là null. Hãy đảm bảo rằng kết nối cơ sở dữ liệu của bạn đã được thiết lập đúng cách.");
            }
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // Nếu xảy ra lỗi, thực hiện rollback để không thay đổi cơ sở dữ liệu
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true); // Bật chế độ tự động commit trở lại
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // Trả về false nếu xóa không thành công
    }
    
    public SanPham timSanPhamTheoMa(String maSanPham) {
        Connection con = null;

        try {
            con = ConnectDB.getConnection();

            if (con != null) {
                String sql = "SELECT * FROM SanPham WHERE maSanPham = ?";
                
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    stmt.setString(1, maSanPham);
                    
                    ResultSet rs = stmt.executeQuery(); // Thực hiện truy vấn

                    if (rs.next()) {
                        String ma = rs.getString("maSanPham").trim();
                        String ten = rs.getString("tenSanPham").trim();
                        Double giaNhap = rs.getDouble("giaNhap");
                        Double giaBan = rs.getDouble("giaBan");
                        String mauSac = rs.getString("mauSac");
                        String xuatXu = rs.getString("xuatXu");
                        String moTa = rs.getString("moTa");
                        String hinhAnh = rs.getString("hinhAnh");
                        LoaiSanPham loaiSanPham = new LoaiSanPham(rs.getString("maLoaiSanPham"));
                        NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("maNhaCungCap"));

                        SanPham sp = new SanPham(ma, ten, giaBan, giaNhap, mauSac, xuatXu, moTa, hinhAnh, loaiSanPham, nhaCungCap);

                        return sp;
                    }
                }
            } else {
                System.out.println("Kết nối là null. Hãy đảm bảo rằng kết nối cơ sở dữ liệu của bạn đã được thiết lập đúng cách.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // Trả về null nếu không tìm thấy sản phẩm
    }


}