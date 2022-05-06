package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> fetchStudentList();

    public Student fetchStudentById(Long studentId) throws StudentNotFoundException;

    public void deleteStudentById(Long studentId);

    public Student updateStudent(Long studentID, Student student);

    public Student fetchStudentByFirstName(String firstName);


}
