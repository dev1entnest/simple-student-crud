package com.example.simple.myspringboot.controllers;

import com.example.simple.myspringboot.dtos.ApiResponse;
import com.example.simple.myspringboot.dtos.StudentDto;
import com.example.simple.myspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponse> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto newStudentDto = studentService.saveStudent(studentDto);
        ApiResponse response = new ApiResponse(200, "Success", newStudentDto);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse> getStudent(@PathVariable(name = "studentId")  Integer studentId){
        StudentDto studentDto = studentService.getStudent(studentId);
        ApiResponse response = new ApiResponse(200, "Success", studentDto);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllStudent() {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        ApiResponse response = new ApiResponse(200, "Success", studentDtos);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<ApiResponse> updateStudent(@RequestBody StudentDto studentDto, @PathVariable(name = "studentId") Integer studentId){
        StudentDto newStudentDto = studentService.updateStudent(studentDto, studentId);
        ApiResponse response = new ApiResponse(200, "Success", newStudentDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable(name = "studentId") Integer studentId){
        studentService.deleteStudent(studentId);
        ApiResponse response = new ApiResponse(200, "Success", "Student Successfully deleted! with id="+studentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
