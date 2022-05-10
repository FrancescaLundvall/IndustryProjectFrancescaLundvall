package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByFirstNameAndLastName(String firstName, String lastName);

    List<Staff> findByDepartmentId(Long departmentId);

}
