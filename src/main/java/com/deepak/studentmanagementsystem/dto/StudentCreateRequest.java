package com.deepak.studentmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class StudentCreateRequest {
    @NotBlank
    private String rollNo;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String phoneNo;
    @Min(1)
    private int departmentId;

    public String getRollNo(){  return rollNo;    }
    public String getName(){    return name;    }
    public String getEmail(){    return email; }
    public String getPhoneNo(){     return phoneNo;     }
    public int getDepartmentId(){   return departmentId;   }

    public void setRollNo(String rollNo){   this.rollNo = rollNo;  }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }
}
