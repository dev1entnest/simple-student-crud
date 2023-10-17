package com.example.simple.myspringboot.repositories;

import com.example.simple.myspringboot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
