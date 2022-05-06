package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StudentNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/student")
    public List<Student> fetchStudentList(){

        return studentService.fetchStudentList();
    }

    @GetMapping("/student/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        return studentService.fetchStudentById(studentId);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentByID(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "Staff member deleted successfully";
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId,
                             @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }


    //When internet is back
    //Find out how to do first and last concat
    @GetMapping("/student/firstName/{firstName}")
    public Student fetchStudentByFirstName(@PathVariable("firstName") String firstName){

        return studentService.fetchStudentByFirstName(firstName);
    }

}
