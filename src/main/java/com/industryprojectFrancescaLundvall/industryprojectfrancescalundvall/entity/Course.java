package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Course {

        @Id
       @GeneratedValue
        private Long courseId;
        private String courseName;
        private String courseCode;
        private Long departmentId;


}
