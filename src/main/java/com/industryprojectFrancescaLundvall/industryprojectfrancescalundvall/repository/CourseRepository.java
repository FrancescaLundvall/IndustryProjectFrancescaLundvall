package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //This displays a list of all courses contained in a particular department
    List<Course> findByDepartmentId(Long departmentId);

    //Search for a course by its name
    Course findByCourseNameIgnoreCase(String courseName);

    //Search for a course by its code
    Course findByCourseCodeIgnoreCase(String courseCode);
}
