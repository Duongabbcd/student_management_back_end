package com.aibles.student_management.dto;


import com.aibles.student_management.entities.Mark;
import com.aibles.student_management.entities.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MarkNewForm {
    private Mark mark ;
    private List<Subject> subjectList = new ArrayList<>() ;
}
