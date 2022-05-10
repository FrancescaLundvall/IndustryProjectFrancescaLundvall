package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    //Find a list of all modules which belong to a particular course
    List<Module> findByCourseId(Long courseId);

    //Find a list of all modules which are taught by a particular staff member
    List<Module> findByStaffId(Long staffId);

    Module findModuleByModuleNameIgnoreCase(String moduleName);
}
