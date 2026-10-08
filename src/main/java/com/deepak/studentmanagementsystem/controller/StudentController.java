package com.deepak.studentmanagementsystem.controller;

import com.deepak.studentmanagementsystem.entity.Student;
import com.deepak.studentmanagementsystem.service.StudentService;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable String rollNo){
         Optional<Student> student = studentService.getStudentByRollNo(rollNo);

         if(student.isPresent()){
             return ResponseEntity.ok(student.get());
         }
         return ResponseEntity.notFound().build();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
        Student student1 = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }

    @PutMapping("/students/{rollNo}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable String rollNo,@Valid @RequestBody Student updatedStudent){
        Student student = studentService.updateStudent(rollNo, updatedStudent);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("/students/{rollNo}")
    public ResponseEntity<Void> deleteStudentByRollNo(@PathVariable String rollNo){
        studentService.deleteStudentByRollNo(rollNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
