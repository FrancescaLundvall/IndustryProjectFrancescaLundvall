package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StaffNotFoundException;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Staff> staff = staffRepository.findById(staffId);
        if(!staff.isPresent()){
            throw new StaffNotFoundException("Staff not found");
        }
        return staff.get();
    }

    @Override
    public void deleteStaffById(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    //Checks that user input is not null.
    // If it is null, assumption is that that field is not being updated and therefore no change is made
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

        if(Objects.nonNull(staff.getAddress()) && !"".equalsIgnoreCase(staff.getAddress())){
            oldStaff.setAddress(staff.getAddress());
        }

        if(Objects.nonNull(staff.getContactNumber()) && !"".equalsIgnoreCase(staff.getContactNumber())){
            oldStaff.setContactNumber(staff.getContactNumber());
        }

        if(Objects.nonNull(staff.getDepartmentId())){
            oldStaff.setDepartmentId(staff.getDepartmentId());
        }

        if(Objects.nonNull(staff.getGender())){
            oldStaff.setGender(staff.getGender());
        }
        return staffRepository.save(oldStaff);
    }

    @Override
    public Staff findByFirstNameAndLastName(String firstName, String lastName) {
        return staffRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Staff> fetchByDepartmentId(Long departmentId) {
        return staffRepository.findByDepartmentId(departmentId);
    }
}
