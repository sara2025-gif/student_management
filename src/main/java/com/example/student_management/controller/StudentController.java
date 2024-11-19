package com.example.student_management.controller;

import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
@Autowired
private StudentService studentService;
@PostMapping
public ResponseEntity<Student>saveEmployee(@RequestBody Student student){
    return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);

}
@GetMapping
public List<Student>getAllStudents(){
    return studentService.getAllStudents();

    }
@GetMapping("/{id}")
public ResponseEntity<Student>getStudentById(@PathVariable("id") long studentID){
    return new ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);
}

@PutMapping("/{id}")
public ResponseEntity<Student>updateStudent(@PathVariable("id")long id,@RequestBody Student student){
    return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);

}
@DeleteMapping("/{id}")
public ResponseEntity<String>deleteStudent(@PathVariable("id")long id){
    studentService.deleteStudent(id);
    return new ResponseEntity<String>("Student deleted succeccfully",HttpStatus.OK);
    
}
@GetMapping("/yearOfEnrollment/{yearOfEnrollment}")
public ResponseEntity<List<Student>>
getEmployeeByFirstName(@PathVariable("yearOfEnrollment")
Integer yearOfEnrollment){
List<Student>student=studentService.getStudentByyearOfEnrollment(yearOfEnrollment);
return new ResponseEntity<>(student,HttpStatus.OK);
}
@GetMapping("/{studentId}/department")
public String getDepartmentByStudentId(@PathVariable Long studentId){
    return studentService.getDepartmentByStudentId(studentId);

}
@DeleteMapping("/enrollment-year/{yearOfEnrollment}")
public ResponseEntity<String>deleteStudentByYearOfEnrollment(@PathVariable Integer yearOfEnrollment){
  studentService.deleteStudentsByYearOfEnrollment(yearOfEnrollment);
  return ResponseEntity.ok("Students enrolled in the year"+yearOfEnrollment+"have been deleted");  
}
}

