package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
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

    @PostMapping("/saveStudent")
    public Student saveStudent(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/getStudent")
    public List<Student> fetchStudentList(){

        return studentService.fetchStudentList();
    }

    @GetMapping("/getStudent/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        return studentService.fetchStudentById(studentId);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudentByID(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "Staff member deleted successfully";
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId,
                             @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }


    @GetMapping("/getStudent/firstName/{firstName}")
    public Student findByFirstName(@PathVariable("firstName") String firstName){

        return studentService.findByFirstName(firstName);
    }

    @GetMapping("/getStudent/{firstName}/{lastName}")
    public Student findByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){

        return studentService.findByFirstNameAndLastName(firstName, lastName);
    }

}
