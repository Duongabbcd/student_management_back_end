package com.aibles.student_management.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class SubjectDTO {
    private long id ;
    private String subjectname;
    private long quantity ;
    private long semester ;
}
