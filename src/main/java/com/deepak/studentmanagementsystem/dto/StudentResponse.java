package com.deepak.studentmanagementsystem.dto;

public class StudentResponse {
    private String rollNo;
    private String name;
    private String email;
    private String phoneNo;
    private int departmentId;

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
