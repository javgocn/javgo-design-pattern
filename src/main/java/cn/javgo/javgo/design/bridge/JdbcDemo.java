package cn.javgo.javgo.design.bridge;

import java.sql.*;

/**
 * Desc：JDBC 驱动下的桥接模式
 *
 * @author javgo
 * @date 2024-08-10
 */
public class JdbcDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        String query = "select * from test";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            rs.getString(1);
            rs.getInt(2);
        }
    }
}
