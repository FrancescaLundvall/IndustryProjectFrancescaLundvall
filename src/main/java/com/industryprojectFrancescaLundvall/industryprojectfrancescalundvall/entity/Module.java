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
public class Module {

    @Id
    /*@SequenceGenerator(
            name = "MODULE_SEQ",
            sequenceName = "MODULE_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MODULE_SEQ"
    )*/
    @GeneratedValue
    private Long moduleId;
    private String moduleName;
    //@Embedded
    //private Staff staff;
    private int EctCredits;
}
