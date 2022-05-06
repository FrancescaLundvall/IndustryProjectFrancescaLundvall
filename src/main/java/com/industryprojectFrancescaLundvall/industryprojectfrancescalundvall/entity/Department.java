package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
   /* @SequenceGenerator(
            name = "DEPT_SEQ",
            sequenceName = "DEPT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DEPT_SEQ"
    )*/
    @GeneratedValue
    private Long departmentId;
    private String departmentName;
    private String departmentCode;

}
