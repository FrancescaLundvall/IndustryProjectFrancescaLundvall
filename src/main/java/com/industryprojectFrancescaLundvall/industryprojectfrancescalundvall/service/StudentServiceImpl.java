package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StudentNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> fetchByCourseId(Long courseId) {
        return studentRepository.findByCourseId(courseId);
    }

    @Override
    public Student fetchStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(studentId);
        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student not found");
        }
        return student.get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Long studentID, Student student) {
        Student oldStudent = studentRepository.findById(studentID).get();

        if (Objects.nonNull(student.getStudentEmail()) && !"".equalsIgnoreCase(student.getStudentEmail())) {
            oldStudent.setStudentEmail(student.getStudentEmail());
        }
        if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
            oldStudent.setFirstName(student.getFirstName());
        }
        if (Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())) {
            oldStudent.setLastName(student.getLastName());
        }
        if (Objects.nonNull(student.getAddress()) && !"".equalsIgnoreCase(student.getAddress())) {
            oldStudent.setAddress(student.getAddress());
        }
        if (Objects.nonNull(student.getContactNumber()) && !"".equalsIgnoreCase(student.getContactNumber())) {
            oldStudent.setContactNumber(student.getContactNumber());
        }
        return studentRepository.save(oldStudent);
    }

    @Override
    public Student findByFirstNameAndLastName(String firstName, String lastName) {
            return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

}
