package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public class Course {
        @Id
        @SequenceGenerator(
                name = "COURSE_SEQ",
                sequenceName = "COURSE_SEQ",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "COURSE_SEQ"
        )
        private Long courseId;
        private String courseName;
        private String courseCode;
        private Long departmentId;

    }
