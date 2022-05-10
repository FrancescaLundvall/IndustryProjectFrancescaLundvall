package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {
    @Id
    @SequenceGenerator(
            name = "STUDENT_SEQ",
            sequenceName = "STUDENT_SEQ",
            allocationSize = 1
    )
    //Generate using the above sequence
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "STUDENT_SEQ"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    private String studentEmail;
    private String address;
    private String contactNumber;
    private char gender;
    private Long courseId;
}
