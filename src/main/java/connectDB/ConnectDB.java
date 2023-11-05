package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLBH;";
    private static final String USER = "sa";
    private static final String PASSWORD = "sapassword";

    private static Connection con = null;

    private ConnectDB() {
        // Private constructor to prevent external instantiation
    }


    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi kết nối cơ sở dữ liệu
            throw new RuntimeException("Kết nối tới cơ sở dữ liệu thất bại");
        }
        return con;
    }

    public static void disconnect() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

