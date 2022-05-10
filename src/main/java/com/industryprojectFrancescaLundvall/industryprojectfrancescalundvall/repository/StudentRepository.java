package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseId(Long courseId);

    Student findByFirstNameAndLastName(String firstName, String lastName);
}
