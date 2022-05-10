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
        /*@ManyToOne( targetEntity = Department.class,
                fetch = FetchType.LAZY)
       /* @JoinTable(
                name = "course_department_map",
                joinColumns = {@JoinColumn(name = "department_id")},
                inverseJoinColumns = {@JoinColumn(name = "course_id")}
        )*/
        private Long departmentId;

        /*@OneToMany(mappedBy = "courseId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Student> students;

        @OneToMany(mappedBy = "courseId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Module> modules;
        */



    }
