package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StaffNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping("/saveStaff")
    public Staff saveStaff(@Valid @RequestBody Staff staff){
        return staffService.saveStaff(staff);
    }


    @GetMapping("/getStaff")
    public List<Staff> fetchStaffList(){
        return staffService.fetchStaffList();

    }

    @GetMapping("/getStaff/{id}")
    public Staff fetchStaffById(@PathVariable("id") Long staffId) throws StaffNotFoundException {
        return staffService.fetchStaffById(staffId);
    }

    @DeleteMapping("/deleteStaff/{id}")
    public String deleteStaffByID(@PathVariable("id") Long staffId){
        staffService.deleteStaffById(staffId);
        return "Staff member deleted successfully";
    }

    @PutMapping("/updateStaff/{id}")
    public Staff updateStaff(@PathVariable("id") Long staffId,
                                       @RequestBody Staff staff) {
        return staffService.updateStaff(staffId,staff);
    }

   @GetMapping("/getStaff/{firstName}/{lastName}")
    public Staff findByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {

        return staffService.findByFirstNameAndLastName(firstName, lastName);
    }
    }

