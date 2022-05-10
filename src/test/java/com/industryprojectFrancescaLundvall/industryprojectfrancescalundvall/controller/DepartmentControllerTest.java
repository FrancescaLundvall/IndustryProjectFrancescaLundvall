package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.controller;

import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity.Department;
import com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.service.DepartmentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

      private Department department;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("History")
                .departmentCode("HI-01")
                .build();

    }

    @Test
    void saveDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departmentName("History")
                .departmentCode("HI-01")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/saveDepartment").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"History\",\n" +
                        "\t\"departmentCode\":\"HI-01\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void deleteDepartmentById() throws Exception {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void fetchDepartmentList() {
    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/getDepartment/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentByName() {
    }
}