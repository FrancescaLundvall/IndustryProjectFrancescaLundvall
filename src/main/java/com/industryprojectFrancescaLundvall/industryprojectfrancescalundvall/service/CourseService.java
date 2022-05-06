package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.CourseNotFoundException;

import java.util.List;

public interface CourseService{

    public Course saveCourse(Course course);

    public List<Course> fetchCourseList();

    public Course fetchCourseById(Long courseId) throws CourseNotFoundException;

    public void deleteCourseById(Long courseId);

    public Course updateCourse(Long courseId, Course course);

    public Course fetchCourseByName(String courseName);

    Course fetchCourseByCourseCode(String courseCode);
}
