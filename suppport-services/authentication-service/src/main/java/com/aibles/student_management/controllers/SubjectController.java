package com.aibles.student_management.controllers;

import com.aibles.student_management.dto.SubjectDTO;
import com.aibles.student_management.respositories.SubjectRepository;
import com.aibles.student_management.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    SubjectService subjectService ;

    @Autowired
    SubjectRepository subjectRepository ;

    @GetMapping(value="/subjects/all" ,produces = "application/json")
    public ResponseEntity<?> findAll(){
        List<SubjectDTO> subjects = subjectService.findAll() ;
        return new ResponseEntity<>(subjects , HttpStatus.OK);
    }
}
