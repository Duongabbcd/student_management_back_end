package com.aibles.student_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class MarkDTO {
    private long id ;
    private double deligence ;
    private double midpoint1 ;
    private double midpoint2 ;
    private String status ;

    @JsonProperty("sub_id")
    private long subId ;

    @JsonProperty("users_id")
    private long userId;

    private String subjectName;
    private String fullName;
}
