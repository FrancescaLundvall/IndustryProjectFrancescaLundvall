package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Department;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.DeptNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//@RequestMapping maps all HTTPS Department requests to /departments
@RestController
@RequestMapping("/departments")
public class DepartmentController {


    //This injects a DepartmentService bean from the application context container
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Department saveDepartment(@Valid @RequestBody Department department){
            return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department " + departmentId + " has been deleted";
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/display")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/display/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DeptNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping("/display/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.fetchDepartmentByName(departmentName);
    }


}
