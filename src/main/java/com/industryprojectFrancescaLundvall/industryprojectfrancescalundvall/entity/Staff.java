package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
//@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
   /* @Column(
            name="staff_email_address",

            //means that there must be an email value for every new staff entry
            nullable = false
    )*/
    private String staffEmail;
    //@Embedded
    //private Department department;
    private String DOB;
    private String address;
    private String contactNumber;
    private char gender;

}
