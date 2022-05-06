package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourse(){

    }

    @Test
    public void saveCourseWithLecturer(){
        Staff staff = Staff.builder()
                .firstName("James")
                .lastName("Terry")
                .build();

        Course course = Course.builder()
                .courseName("ZZ")
                .build();

        courseRepository.save(course);
    }

    /*@Test
    public void saveCourseWithStudentAndTeacher(){

        courseRepository.save(course);
    }*/

}
