package com.ohgiraffers.section01.run;

import com.ohgiraffers.section01.model.dao.EmployeeDAO;
import com.ohgiraffers.section01.model.dao.MenuDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.JDBCTemplete.getConnection;

public class Application01 {

    public static void main(String[] args) {

        Connection con = getConnection();
        // jtbctemplete 를 가지고오는 용도

        // employee DAO 연결
        EmployeeDAO registDAO = new EmployeeDAO();

        // 필기. employee_ID, employ_menu 출력하기

        System.out.println(con);



        List<Map<String, Object>> resultList = registDAO.check(con);

        for(Map<String, Object> result : resultList) {
            System.out.println("result = " + result);
        }












    }

}
