package com.deepak.studentmanagementsystem.controller;

import com.deepak.studentmanagementsystem.dto.StudentUpdateRequest;
import com.deepak.studentmanagementsystem.entity.Student;
import com.deepak.studentmanagementsystem.service.StudentService;
import com.deepak.studentmanagementsystem.dto.StudentCreateRequest;
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

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("/students/{rollNo}")
    public ResponseEntity<Student> getStudentByRollNo(
            @PathVariable String rollNo){

         Optional<Student> student = studentService.getStudentByRollNo(rollNo);

         if(student.isPresent()){
             return ResponseEntity.ok(student.get());
         }
         return ResponseEntity.notFound().build();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody StudentCreateRequest request){
        Student s = new Student();
        s.setRollNo(request.getRollNo());
        s.setName(request.getName());
        s.setEmail(request.getEmail());
        s.setPhoneNo(request.getPhoneNo());
        s.setDepartmentId(request.getDepartmentId());
        Student student1 = studentService.addStudent(s);
        return ResponseEntity.status(HttpStatus.CREATED).body(student1);

    }

    @PutMapping("/students/{rollNo}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable String rollNo,@Valid @RequestBody StudentUpdateRequest request){

        Student s = new Student();

        s.setName(request.getName());
        s.setEmail(request.getEmail());
        s.setPhoneNo(request.getPhoneNo());
        s.setDepartmentId(request.getDepartmentId());

        Student student = studentService.updateStudent(rollNo, s);
        return ResponseEntity.status(HttpStatus.OK).body(student);

    }

    @DeleteMapping("/students/{rollNo}")
    public ResponseEntity<Void> deleteStudentByRollNo(
            @PathVariable String rollNo){

        studentService.deleteStudentByRollNo(rollNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
