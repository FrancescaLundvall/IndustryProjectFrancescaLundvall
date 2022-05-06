package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StaffNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/staff")
    public Staff saveStaff(@Valid @RequestBody Staff staff){
        return staffService.saveStaff(staff);
    }

    @GetMapping("/staff")
    public List<Staff> fetchStaffList(){

        return staffService.fetchStaffList();
    }

    @GetMapping("/staff/{id}")
    public Staff fetchStaffById(@PathVariable("id") Long staffId) throws StaffNotFoundException {
        return staffService.fetchStaffById(staffId);
    }

    @DeleteMapping("/staff/{id}")
    public String deleteStaffByID(@PathVariable("id") Long staffId){
        staffService.deleteStaffById(staffId);
        return "Staff member deleted successfully";
    }

    @PutMapping("/staff/{id}")
    public Staff updateStaff(@PathVariable("id") Long staffId,
                                       @RequestBody Staff staff) {
        return staffService.updateStaff(staffId,staff);
    }

    //When internet is back
    //Find out how to do first and last concat
    @GetMapping("/staff/firstName/{firstName}")
    public Staff fetchStaffByFirstName(@PathVariable("firstName") String firstName){

        return staffService.fetchStaffByFirstName(firstName);
    }
    }

