package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Staff {

    @Id
    @SequenceGenerator(
            name = "STAFF_SEQ",
            sequenceName = "STAFF_SEQ",
           allocationSize = 1
     )
    @GeneratedValue(
       strategy = GenerationType.SEQUENCE,
      generator = "STAFF_SEQ"
    )
    private Long staffId;
    private String firstName;
    private String lastName;
    private String staffEmail;
    //@ManyToOne(targetEntity = Department.class)
    private Long departmentId;
    private String address;
    private String contactNumber;
    private char gender;

}