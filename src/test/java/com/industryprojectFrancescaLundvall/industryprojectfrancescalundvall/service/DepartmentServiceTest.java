package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Department;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setup(){
        Department department = Department.builder()
                .departmentCode("H-1")
                .departmentName("History")
                .build();

        //Whenever findbyname is called, return department created above
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("History")).thenReturn(department);
       // Mockito.when(departmentRepository.)
    }

    @Test
    void saveDepartment() {


    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void fetchDepartmentById() {
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    @DisplayName("Get department by departmentName")
    void getByDepartmentNameTest() {
        String departmentName = "History";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}