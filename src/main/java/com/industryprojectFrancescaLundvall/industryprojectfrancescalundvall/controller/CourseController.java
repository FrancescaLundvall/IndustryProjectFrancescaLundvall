package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Department;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.CourseNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public Course saveCourse(@Valid @RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return "Course " +courseId + " has been deleted";
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable("id") Long courseId, @RequestBody Course course){
        return courseService.updateCourse(courseId, course);
    }

    @GetMapping("/display")
    public List<Course> fetchCourseList(){
        return courseService.fetchCourseList();
    }

    @GetMapping("/display/{id}")
    public Course fetchCourseById(@PathVariable("id") Long courseId) throws CourseNotFoundException {
        return courseService.fetchCourseById(courseId);
    }

    @GetMapping("/display/name/{name}")
    public Course fetchCourseByName(@PathVariable("name") String courseName){
        return courseService.fetchCourseByName(courseName);
    }

    @GetMapping("/display/code/{code}")
    public Course fetchCourseByCourseCode(@PathVariable("code") String courseCode){
        return courseService.fetchCourseByCourseCode(courseCode);
    }

    @GetMapping("/display/departmentID/{departmentId}")
    public List<Course> findByDepartmentId(@PathVariable("departmentId") Long departmentId){
        return courseService.findByDepartmentId(departmentId);
    }
}
