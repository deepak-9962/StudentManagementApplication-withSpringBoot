package com.deepak.studentmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;

    @Entity
    @Table(name = "students")
    public class Student {
        @NotBlank
        @Id
        @Column(name = "roll_no")
        private String rollNo;

        @NotBlank
        private String name;
        @Email
        private String email;

        @NotBlank
        @Pattern(regexp = "\\d{10}")
        @Column(name = "phone_no")
        private String phoneNo;
        @Min(1)
        @Column(name = "department_id")
        private int departmentId;


        public Student() {

        }

        public String getRollNo(){
            return rollNo;
        }
        public void setRollNo(String rollNo){
            this.rollNo = rollNo;
        }

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }

        public String getPhoneNo(){
            return phoneNo;
        }
        public void setPhoneNo(String phoneNo){
            this.phoneNo = phoneNo;
        }

        public int getDepartmentId(){
            return departmentId;
        }
        public void setDepartmentId(int departmentId){
            this.departmentId = departmentId;
        }

    }

