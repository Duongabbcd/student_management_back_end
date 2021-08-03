package com.aibles.student_management.service;

import com.aibles.student_management.entities.Subject;
import com.aibles.student_management.entities.User;
import com.aibles.student_management.respositories.MarkRepository;
import com.aibles.student_management.respositories.SubjectRepository;
import com.aibles.student_management.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired protected MarkRepository markRepository ;
    @Autowired
    protected SubjectRepository subjectRepository ;
    @Autowired protected UserRepository userRepository ;

    protected User initUser(long id){
        return userRepository.findUserById(id);
    }

    protected Subject initSubject(long id){
        return subjectRepository.findSubjectById(id);
    }
}
