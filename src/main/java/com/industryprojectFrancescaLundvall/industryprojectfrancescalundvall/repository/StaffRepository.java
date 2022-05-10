package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    //Find a particular staff member by their full name
    Staff findByFirstNameAndLastName(String firstName, String lastName);

    //Find a list of all staff who teach in a particular department
    List<Staff> findByDepartmentId(Long departmentId);

}
