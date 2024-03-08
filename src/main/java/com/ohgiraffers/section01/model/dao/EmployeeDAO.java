package com.ohgiraffers.section01.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplete.close;


// 데이터 베이스의 접근용 객체
// 연산을 담당하는 메소드로 이루어진 클래스
public class EmployeeDAO {

    private Properties prop = new Properties();
    // 컬렉션 properties 의 prop 생성

    public EmployeeDAO() {
    // xml 이랑 연결 하는 메소드

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/emp-query.xml"));
            // 컬렉션 properties 의 propdml loadfromxml 을 이용하여 emp-query.xml 의 절대경로 입력

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> check (Connection con) {
        // 연산 담당 메서드

        Statement stmt = null;
        // 쿼리를 실행할 인터페이스 설정값 지정
        ResultSet rset = null;
        // 쿼리 값을 저장할 인터페이스 설정값 지정
        List<Map<String, Object>> resultList = new ArrayList<>();

        
        int result = 0;
        // 결과 확인용 값 0으로 초기화

        String query = prop.getProperty("abcd");
        // xml 의 entry key 값 연동

        try {
            stmt = con.createStatement();
            // statement 생성
            rset = stmt.executeQuery(query);
            // statement 실행 문에 query 값을 넣어서 resultset 값 생성

            resultList = new ArrayList<>();

            while (rset.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("EMP_ID", rset.getInt("EMP_ID"));
                row.put("EMP_NAME", rset.getString("EMP_NAME"));
                resultList.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);

            // jdbc templete 의 Close 메소드를 이용하여 닫아주기
        }

        return resultList;
    }





    








}
