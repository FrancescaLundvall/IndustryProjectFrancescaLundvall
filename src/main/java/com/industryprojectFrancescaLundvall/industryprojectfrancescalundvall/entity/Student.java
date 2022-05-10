package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*@Table(
        name = "students",

        //means every email must be unique
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "email_address"
        )
)*/
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
    //@ManyToOne(targetEntity = Course.class)
    private Long courseId;
}
