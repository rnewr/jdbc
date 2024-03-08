package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplete {

    public static Connection getConnection() {
        // return 값을 가진 connection 인터페이스의 getconnection 메소드

        Connection con = null;
        // connection 값을 null로 초기화

        Properties prop = new Properties();
        // 컬렉션 Properties 사용목적으로 prop 생성

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info2.properties"));
//            prop.load(new FileReader("src/main/java/com/ohgiraffers/config.connection-info.properties"));
            // prop 의 로드의 filereader을 통해 미리 만둘어 둔 jdbctemplete 의 절대주소 값을 지정한다.
            // info2 = employee, info = menudb

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            // properties 키를 통해

            Class.forName(driver);
            //드라이버 실행
            con = DriverManager.getConnection(url,prop);
            // 인터페이스 connection 의 con 값을 드라이버를 통해 연결하는 과정

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con) {

        try {
            if(con != null && !con.isClosed()) {

                con.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void close(Statement stmt) {

        try {
            if(stmt != null && !stmt.isClosed()) {

                stmt.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void close(ResultSet rset) {

        try {
            if(rset != null && !rset.isClosed()) {

                rset.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
