package com.example.simple.myspringboot.service;

import com.example.simple.myspringboot.dtos.StudentDto;
import com.example.simple.myspringboot.entities.Student;
import com.example.simple.myspringboot.exceptionns.ApplicationException;
import com.example.simple.myspringboot.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Student savedStudent = studentRepository.save(student);
        StudentDto newStudent = modelMapper.map(savedStudent, StudentDto.class);
        return newStudent;
    }

    @Override
    public StudentDto getStudent(Integer studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(()->new ApplicationException("Can't find the student with id="+studentId));
        StudentDto studentDto=modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Integer studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new ApplicationException("Can't find the student with id="+studentId));
        student.setName(studentDto.getName());
        student.setBranch(studentDto.getBranch());
        studentRepository.save(student);
        StudentDto studentDto1 = modelMapper.map(student, StudentDto.class);
        return studentDto1;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new ApplicationException("Can't find the student with id="+studentId));
        studentRepository.delete(student);
    }
}
