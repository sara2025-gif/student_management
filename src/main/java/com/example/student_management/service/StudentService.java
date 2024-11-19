package com.example.student_management.service;
import com.example.student_management.model.Student;
import java.util.List;
public interface StudentService {
    Student saveStudent(Student student);
    List<Student>getAllStudents();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id);
    void deleteStudent(long id);

    List<Student>getStudentByYearOfEnrollment(Integer yearOfEnrollment);
    String getDepartmentByStudentId(Long studentId);
    void deleteStudentsByYearOfEnrollment(Integer yearOfEnrollment);
    List<Student> getStudentByyearOfEnrollment(Integer yearOfEnrollment);
   
   
    }
    

