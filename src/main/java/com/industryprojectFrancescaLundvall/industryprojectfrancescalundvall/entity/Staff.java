package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
/*@Table(
        name = "staff",

        //means every email must be unique
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "email_address"
        )
)*/

public class Staff {

    @Id
    //@SequenceGenerator(
    //        name = "STAFF_SEQ",
    //        sequenceName = "STAFF_SEQ",
    //       allocationSize = 1
    // )
    @GeneratedValue//(
    //   strategy = GenerationType.SEQUENCE,
    //  generator = "STAFF_SEQ"
    //)
    private Long staffId;
    private String firstName;
    private String lastName;
    private String staffEmail;
    private Long departmentId;
    private String address;
    private String contactNumber;
    private char gender;

}