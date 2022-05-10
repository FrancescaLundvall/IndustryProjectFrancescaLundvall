package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Course;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StaffNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RequestMapping maps all HTTPS Staff requests to /staff
@RestController
@RequestMapping("/staff")
public class StaffController {

    //This injects a StaffService bean from the application context container
    @Autowired
    private StaffService staffService;

    @PostMapping("/save")
    public Staff saveStaff(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @GetMapping("/display")
    public List<Staff> fetchStaffList(){
        return staffService.fetchStaffList();

    }

    @GetMapping("/display/{id}")
    public Staff fetchStaffById(@PathVariable("id") Long staffId) throws StaffNotFoundException {
        return staffService.fetchStaffById(staffId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStaffByID(@PathVariable("id") Long staffId){
        staffService.deleteStaffById(staffId);
        return "Staff member deleted successfully";
    }

    @PutMapping("/update/{id}")
    public Staff updateStaff(@PathVariable("id") Long staffId,
                                       @RequestBody Staff staff) {
        return staffService.updateStaff(staffId,staff);
    }

   @GetMapping("/display/{firstName}/{lastName}")
    public Staff findByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {

        return staffService.findByFirstNameAndLastName(firstName, lastName);
    }

    //This requests list of all staff who are in a particular department
    @GetMapping("/display/departmentID/{departmentId}")
    public List<Staff> findByDepartmentId(@PathVariable("departmentId") Long departmentId){
        return staffService.fetchByDepartmentId(departmentId);
    }
    }

