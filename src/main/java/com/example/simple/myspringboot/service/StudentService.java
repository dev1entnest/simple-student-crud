package com.example.simple.myspringboot.service;

import com.example.simple.myspringboot.dtos.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto saveStudent(StudentDto student);
    StudentDto getStudent(Integer studentId);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(StudentDto student, Integer studentId);
    void deleteStudent(Integer studentId);
}
