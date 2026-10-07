package com.deepak.studentmanagementsystem.controller;

import com.deepak.studentmanagementsystem.entity.Student;
import com.deepak.studentmanagementsystem.service.StudentService;
import java.util.List;
import java.util.Optional;
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
    public Student addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/students/{rollNo}")
    public Student updateStudent(@PathVariable String rollNo,@Valid @RequestBody Student updatedStudent){
        return studentService.updateStudent(rollNo, updatedStudent);
    }
    @DeleteMapping("/students/{rollNo}")
    public void deleteStudentByRollNo(@PathVariable String rollNo){
        studentService.deleteStudentByRollNo(rollNo);
    }

}
