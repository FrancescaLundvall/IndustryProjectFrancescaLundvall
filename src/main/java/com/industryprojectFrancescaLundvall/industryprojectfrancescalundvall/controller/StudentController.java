package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Module;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StudentNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Student saveStudent(@Valid @RequestBody Student student){

        return studentService.saveStudent(student);
    }

    @GetMapping("/display")
    public List<Student> fetchStudentList(){

        return studentService.fetchStudentList();
    }

    @GetMapping("/display/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        return studentService.fetchStudentById(studentId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentByID(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "Student deleted successfully";
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId,
                             @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }


    @GetMapping("/display/{firstName}/{lastName}")
    public Student findByFirstNameAndLastName(@PathVariable("firstName") String firstName,
                                              @PathVariable("lastName") String lastName){

        return studentService.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/display/courseId/{courseId}")
    List<Student> fetchByCourseId(Long courseId){
        return studentService.fetchByCourseId(courseId);
    }

}
