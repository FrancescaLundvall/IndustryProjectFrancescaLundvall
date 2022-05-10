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
public class Department {

    @Id
   @SequenceGenerator(
            name = "DEPT_SEQ",
            sequenceName = "DEPT_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DEPT_SEQ"
    )
    private Long departmentId;
    private String departmentName;
    private String departmentCode;

 //   @OneToMany(mappedBy = "departmentId",  fetch = FetchType.LAZY,            cascade = CascadeType.ALL)
   /* @JoinTable(
            name = "course_department_map",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")}
    )
    private List<Course> courses;

    @OneToMany(mappedBy = "departmentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Staff> staff;
*/
}
