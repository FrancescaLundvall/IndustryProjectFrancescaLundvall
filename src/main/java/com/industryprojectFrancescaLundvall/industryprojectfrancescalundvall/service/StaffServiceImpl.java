package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StaffNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staff saveStaff(Staff staff) {
       return staffRepository.save(staff);
    }

    @Override
    public List<Staff> fetchStaffList() {
        return staffRepository.findAll();
    }

    @Override
    public Staff fetchStaffById(Long staffId) throws StaffNotFoundException {
        return null;
    }

    @Override
    public void deleteStaffById(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public Staff updateStaff(Long staffId, Staff staff) {
        Staff oldStaff = staffRepository.findById(staffId).get();

        if(Objects.nonNull(staff.getStaffEmail()) && !"".equalsIgnoreCase(staff.getStaffEmail())){
            oldStaff.setStaffEmail(staff.getStaffEmail());
        }
        if(Objects.nonNull(staff.getFirstName()) && !"".equalsIgnoreCase(staff.getFirstName())){
            oldStaff.setFirstName(staff.getFirstName());
        }
        if(Objects.nonNull(staff.getLastName()) && !"".equalsIgnoreCase(staff.getLastName())){
            oldStaff.setLastName(staff.getLastName());
        }

        if(Objects.nonNull(staff.getDOB()) && !"".equalsIgnoreCase(staff.getDOB())){
            staff.setDOB(staff.getDOB());
        }

        if(Objects.nonNull(staff.getAddress()) && !"".equalsIgnoreCase(staff.getAddress())){
            oldStaff.setAddress(staff.getAddress());
        }

        if(Objects.nonNull(staff.getContactNumber()) && !"".equalsIgnoreCase(staff.getContactNumber())){
            oldStaff.setContactNumber(staff.getContactNumber());
        }

       // if(Objects.nonNull(staff.getDepartment())){
         //   oldStaff.setDepartment(staff.getDepartment());
        //}

        return staffRepository.save(oldStaff);
    }

    @Override
    public Staff fetchStaffByFirstName(String firstName) {
        return null;
    }
}
