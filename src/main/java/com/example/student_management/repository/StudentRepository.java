package com.example.student_management.repository;

import com.example.student_management.model.Student;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long>{
List<Student>findByYearOfEnrollment(int yearOfEnrollment);
@Query("SELECT s.department FROM Student s WHERE s.id=:studentId")
String findDepartmentNameByStudentId(@Param("studentId")Long studentId);
@Transactional
void deleteByYearOfEnrollment(Integer yearOfEnrollment);
} 


