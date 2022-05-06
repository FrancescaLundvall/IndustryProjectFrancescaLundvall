package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.CourseNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {return courseRepository.save(course);}

    @Override
    public List<Course> fetchCourseList() {
        return courseRepository.findAll();
    }

    @Override
    public Course fetchCourseById(Long courseId) throws CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            return course.get();
        }
        else throw new CourseNotFoundException("Course not found");

    }

    @Override
    public void deleteCourseById(Long courseId) {courseRepository.deleteById(courseId);}

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course oldCourse = courseRepository.findById(courseId).get();

        if(Objects.nonNull(course.getCourseName()) && !"".equalsIgnoreCase(course.getCourseName()))
        {
            oldCourse.setCourseName(course.getCourseName());
        }

        if(Objects.nonNull(course.getCourseCode()) && !"".equalsIgnoreCase(course.getCourseCode())){
            oldCourse.setCourseCode(course.getCourseCode());
        }
        return courseRepository.save(oldCourse);
    }

    @Override
    public Course fetchCourseByName(String courseName) {
        return courseRepository.findByCourseNameIgnoreCase(courseName);
    }

    @Override
    public Course fetchCourseByCourseCode(String courseCode) {
        return courseRepository.findByCourseCodeIgnoreCase(courseCode);
    }
}
