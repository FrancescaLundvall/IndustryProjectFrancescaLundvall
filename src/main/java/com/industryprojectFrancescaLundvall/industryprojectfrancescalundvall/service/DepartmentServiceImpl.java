package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Department;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.DeptNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long deptId) {departmentRepository.deleteById(deptId);}

    @Override
    public Department updateDepartment(Long deptId, Department department) {
        Department currentDept = departmentRepository.findById(deptId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
        { currentDept.setDepartmentName(department.getDepartmentName());}
        return departmentRepository.save(currentDept);
    }

    @Override
    public Department fetchDepartmentById(Long deptId) throws DeptNotFoundException {
        Optional<Department> department = departmentRepository.findById(deptId);
        if(!department.isPresent()){
            throw new DeptNotFoundException("Department not found");
        }
        return department.get();
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
