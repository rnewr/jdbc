package com.ohgiraffers.section01.model.dto;

// 데이터 베이스의 데이터 값을 모아둔 클래스
public class EmployeeDTO {
     //select EMP_ID, EMP_NAME from EMPLOYEE;
    private int empId;
    private String empName;

    public EmployeeDTO() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                '}';
    }
}
