package com.example.simple.myspringboot.dtos;


import com.example.simple.myspringboot.entities.Branch;
import lombok.Data;

@Data
public class StudentDto {
    private Integer studentId;
    private String name;
    private Branch branch;
}
