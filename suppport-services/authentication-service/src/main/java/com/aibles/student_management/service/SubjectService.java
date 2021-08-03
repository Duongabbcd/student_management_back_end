package com.aibles.student_management.service;

import com.aibles.student_management.dto.SubjectDTO;
import com.aibles.student_management.entities.Subject;
import com.aibles.student_management.respositories.SubjectRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    public List<SubjectDTO> converteToSubjectDTO(List<Subject> subjects){
        return subjects.stream().map(modelMapper :: convertertoSubjectDTO).collect(Collectors.toList());
    }

    public List<SubjectDTO> findAll() {
        return converteToSubjectDTO(subjectRepository.findAll()) ;
    }

}
