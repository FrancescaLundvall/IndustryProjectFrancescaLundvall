package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    /*@Table(
            name = "courses",

            //means every email must be unique
            uniqueConstraints = @UniqueConstraint(
                    name = "courseId_unique",
                    columnNames = "course_Id"
            )
    )*/
    public class Course {

        @Id
       /* @Column(
                name="course_Id",

                //means that there must be a course ID value assigned for every new course entry
                nullable = false
        )*/
        @GeneratedValue
        private Long courseId;
        private String courseName;
        private String courseCode;

}
