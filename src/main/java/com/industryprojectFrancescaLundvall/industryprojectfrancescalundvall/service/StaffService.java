package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Staff;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception.StaffNotFoundException;

import java.util.List;

public interface StaffService {

    public Staff saveStaff(Staff staff);

    public List<Staff> fetchStaffList();

    public Staff fetchStaffById(Long staffId) throws StaffNotFoundException;

    public void deleteStaffById(Long staffId);

    public Staff updateStaff(Long staffId, Staff staff);

    public Staff fetchStaffByFirstName(String firstName);
}
