package com.aibles.student_management.service;

import com.aibles.student_management.dto.MarkDTO;
import com.aibles.student_management.entities.Mark;
import com.aibles.student_management.respositories.MarkRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@Service
@Transactional
public class MarkService {
    @Autowired
    private MarkRepository markRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    public List<MarkDTO> getMarkByUser(Long id) {
        List<Mark> marks = markRepository.findAllByUserId(id);
        return converteToMarkDTO(marks) ;
    }


    public List<MarkDTO> converteToMarkDTO(List<Mark> marks){
        return marks.stream().map(modelMapper :: convertertoMarkDTO).collect(Collectors.toList());
    }



    public Mark createMark(Mark mark) {
        return markRepository.save(mark);
    }

    public Mark updateMark(Mark mark){
        Mark m = markRepository.findById(mark.getId()).orElse(null);
        if(m != null ){
            m.setDeligence(mark.getDeligence());
            m.setMidpoint1(mark.getMidpoint1());
            m.setMidpoint2(mark.getMidpoint2());
            m.setStatus(mark.getStatus());

            markRepository.save(m);
        }
        return m ;
    }

    public List<MarkDTO> findAll() {
        return converteToMarkDTO(markRepository.findAll()) ;
    }



}
