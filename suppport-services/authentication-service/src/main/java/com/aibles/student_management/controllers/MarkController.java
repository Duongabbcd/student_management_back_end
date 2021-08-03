package com.aibles.student_management.controllers;


import com.aibles.student_management.dto.MarkDTO;
import com.aibles.student_management.entities.Mark;
import com.aibles.student_management.respositories.MarkRepository;
import com.aibles.student_management.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarkController {

    @Autowired
    MarkService markService ;

    @Autowired
    MarkRepository markRepository ;

    @PostMapping(value = "/marks/save", produces = "application/json")
    public ResponseEntity<?> createMark(@RequestBody Mark mark) {
        markService.createMark(mark) ;
        return new ResponseEntity<>(mark, HttpStatus.OK);
    }

    @PutMapping(value = "/marks/update", produces = "application/json")
    public ResponseEntity<?> updateMark(@RequestBody Mark mark) {
        markService.updateMark(mark); ;
        return new ResponseEntity<>(mark, HttpStatus.OK);
    }


    @GetMapping(value = "/marks/{id}", produces = "application/json")
    public ResponseEntity<?> findByUserId(@PathVariable long id) {
     List<MarkDTO> marks = markService.getMarkByUser(id); ;
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }

    @GetMapping(value="/marks/all" ,produces = "application/json")
    public ResponseEntity<?>  findAll(){
        List<MarkDTO> marks = markService.findAll() ;
       return new ResponseEntity<>(marks ,HttpStatus.OK);
    }


}
