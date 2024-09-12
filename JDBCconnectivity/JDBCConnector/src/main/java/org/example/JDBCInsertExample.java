package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/authentication_db";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 101);
            pstmt.setString(2, "Jenny");
            pstmt.setInt(3, 25);
            pstmt.setDouble(4, 10000.00);
            pstmt.addBatch();

            pstmt.setInt(1, 102);
            pstmt.setString(2, "Jacky");
            pstmt.setInt(3, 30);
            pstmt.setDouble(4, 20000.00);
            pstmt.addBatch();

            pstmt.setInt(1, 103);
            pstmt.setString(2, "Joe");
            pstmt.setInt(3, 20);
            pstmt.setDouble(4, 40000.00);
            pstmt.addBatch();

            pstmt.setInt(1, 104);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 40);
            pstmt.setDouble(4, 80000.00);
            pstmt.addBatch();

            pstmt.setInt(1, 105);
            pstmt.setString(2, "Shameer");
            pstmt.setInt(3, 25);
            pstmt.setDouble(4, 90000.00);
            pstmt.addBatch();

            pstmt.executeBatch();

            System.out.println("Records inserted successfully!");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}