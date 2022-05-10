package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.CourseNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/saveCourse")
    public Course saveCourse(@Valid @RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return "Course " +courseId + "has been deleted";
    }

    @PutMapping("/updateCourse/{id}")
    public Course updateCourse(@PathVariable("id") Long courseId, @RequestBody Course course){
        return courseService.updateCourse(courseId, course);
    }

    @GetMapping("/getCourse")
    public List<Course> fetchCourseList(){
        return courseService.fetchCourseList();
    }

    @GetMapping("/getCourse/{id}")
    public Course fetchCourseById(@PathVariable("id") Long courseId) throws CourseNotFoundException {
        return courseService.fetchCourseById(courseId);
    }

    @GetMapping("/getCourse/name/{name}")
    public Course fetchCourseByName(@PathVariable("name") String courseName){
        return courseService.fetchCourseByName(courseName);
    }

    @GetMapping("/getCourse/code/{code}")
    public Course fetchCourseByCourseCode(@PathVariable("code") String courseCode){
        return courseService.fetchCourseByCourseCode(courseCode);
    }

    @GetMapping("/getCourse/departmentID/{departmentId}")
    public List<Course> findByDepartmentId(@PathVariable("departmentId") Long departmentId){
        return courseService.findByDepartmentId(departmentId);
    }
}
