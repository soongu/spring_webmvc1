package com.spring.webmvc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectTest {

    private String uid = "hr";
    private String upw = "hr";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    @Test
    void connectTest() {

        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "SELECT first_name FROM employees";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("first_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
