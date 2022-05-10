package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Module {
    @Id
    @SequenceGenerator(
            name = "MODULE_SEQ",
            sequenceName = "MODULE_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MODULE_SEQ"
    )
    private Long moduleId;
    private String moduleName;
    private int EctCredits;
    private Long staffId;
    private Long courseId;

}
