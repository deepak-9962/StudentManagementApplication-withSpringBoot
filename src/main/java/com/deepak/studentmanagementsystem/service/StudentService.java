package com.deepak.studentmanagementsystem.service;

import com.deepak.studentmanagementsystem.exception.StudentNotFoundException;
import com.deepak.studentmanagementsystem.repository.StudentRepository;
import com.deepak.studentmanagementsystem.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByRollNo(String rollNo){
        return studentRepository.findById(rollNo);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(String rollNo, Student updatedStudent){
        Optional<Student> existingStudent =  studentRepository.findById(rollNo);

        if(existingStudent.isPresent()){
            Student student = existingStudent.get();

            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setPhoneNo(updatedStudent.getPhoneNo());
            student.setDepartmentId(updatedStudent.getDepartmentId());

            return studentRepository.save(student);
        }
        throw new StudentNotFoundException(
                "The Student with Roll Number " + rollNo + " is Not Found");
    }

    public void deleteStudentByRollNo(String rollNo){
        studentRepository.deleteById(rollNo);
    }

}

