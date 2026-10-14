package com.deepak.studentmanagementsystem.mapper;

import com.deepak.studentmanagementsystem.dto.StudentCreateRequest;
import org.springframework.stereotype.Component;
import com.deepak.studentmanagementsystem.dto.StudentResponse;
import com.deepak.studentmanagementsystem.entity.Student;

@Component
public class StudentMapper {

    public StudentResponse toStudentResponse(Student student){

        StudentResponse response = new StudentResponse();

        response.setRollNo(student.getRollNo());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setPhoneNo(student.getPhoneNo());
        response.setDepartmentId(student.getDepartmentId());

        return response;
    }

    public Student FromStudentCreateRequestToStudent(StudentCreateRequest request){
        Student student = new Student();

        student.setRollNo(request.getRollNo());
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPhoneNo(request.getPhoneNo());
        student.setDepartmentId(request.getDepartmentId());

        return student;
    }
}
