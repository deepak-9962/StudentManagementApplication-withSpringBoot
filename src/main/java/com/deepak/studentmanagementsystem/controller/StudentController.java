package com.deepak.studentmanagementsystem.controller;

import com.deepak.studentmanagementsystem.dto.StudentResponse;
import com.deepak.studentmanagementsystem.dto.StudentUpdateRequest;
import com.deepak.studentmanagementsystem.entity.Student;
import com.deepak.studentmanagementsystem.mapper.StudentMapper;
import com.deepak.studentmanagementsystem.service.StudentService;
import com.deepak.studentmanagementsystem.dto.StudentCreateRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import javax.swing.plaf.synth.SynthTableUI;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper){

        this.studentService = studentService;
        this.studentMapper = studentMapper;

    }
    @GetMapping("/students")
    public List<StudentResponse> getAllStudents(){

        List<StudentResponse> responses = new ArrayList<>();

        List<Student> students = studentService.getAllStudents();

        for(Student student : students){

            responses.add(studentMapper.toStudentResponse(student));
        }
        return responses;
    }


    @GetMapping("/students/{rollNo}")
    public ResponseEntity<StudentResponse> getStudentByRollNo(
            @PathVariable String rollNo){

         Student student = studentService.getStudentByRollNo(rollNo);

         StudentResponse response = studentMapper.toStudentResponse(student);

         return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponse> addStudent(
            @Valid @RequestBody StudentCreateRequest request){

        Student studentEntity = studentMapper.FromStudentCreateRequestToStudent(request);

        Student savedStudent = studentService.addStudent(studentEntity);

        StudentResponse response = studentMapper.toStudentResponse(savedStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping("/students/{rollNo}")
    public ResponseEntity<StudentResponse> updateStudent(
            @PathVariable String rollNo,@Valid @RequestBody StudentUpdateRequest request){

        Student s = new Student();

        s.setName(request.getName());
        s.setEmail(request.getEmail());
        s.setPhoneNo(request.getPhoneNo());
        s.setDepartmentId(request.getDepartmentId());

        Student student = studentService.updateStudent(rollNo, s);

        StudentResponse response = studentMapper.toStudentResponse(student);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/students/{rollNo}")
    public ResponseEntity<Void> deleteStudentByRollNo(
            @PathVariable String rollNo){

        studentService.deleteStudentByRollNo(rollNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
