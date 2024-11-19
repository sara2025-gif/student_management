package com.example.student_management.service.impl;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

  
  
   
   @Autowired
   private StudentRepository studentRepository;

   @Override
   public Student saveStudent(Student student){
    return studentRepository.save(student);

   }
   @Override
   public List<Student>getAllStudents(){
    return studentRepository.findAll();
   }
   @Override
   public Student updateStudent(Student student, long id){
    Student existingStudent=studentRepository.findById(id).orElseThrow(()->new RuntimeException("student not found"));

    existingStudent.setFirstName(student.getFirstName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setEmail(student.getEmail());
    existingStudent.setDepartment(student.getDepartment());
    existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
    return studentRepository.save(existingStudent);
   }
   @Override
   public void deleteStudent(long id){
    studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
    studentRepository.deleteById(id);
   }
   @Override
   public Student getStudentById(long id) {
      
      throw new UnsupportedOperationException("Unimplemented method 'getStudentById'");
   }

   //other methods
  // @Override
   public List<Student> getStudentsByYearOfEnrollment(Integer yearOfEnrollment){
      return studentRepository.findByYearOfEnrollment(yearOfEnrollment);}

      @Override
      public String getDepartmentByStudentId(Long studentId){
         return studentRepository.findDepartmentNameByStudentId(studentId);
      }

      @Override
      public void deleteStudentsByYearOfEnrollment(Integer yearOfEnrollment){
         studentRepository.deleteByYearOfEnrollment(yearOfEnrollment);
      }
      @Override
      public List<Student> getStudentByYearOfEnrollment(Integer yearOfEnrollment) {
     
         throw new UnsupportedOperationException("Unimplemented method 'getStudentByYearOfEnrollment'");
      }
      @Override
      public List<Student> getStudentByyearOfEnrollment(Integer yearOfEnrollment) {
      
         throw new UnsupportedOperationException("Unimplemented method 'getStudentByyearOfEnrollment'");
      }
      
   }

