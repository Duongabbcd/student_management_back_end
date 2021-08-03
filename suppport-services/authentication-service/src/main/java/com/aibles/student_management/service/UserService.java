package com.aibles.student_management.service;


import com.aibles.student_management.dto.UserDTO;
import com.aibles.student_management.entities.User;
import com.aibles.student_management.respositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
public class UserService {
    @Autowired
    ModelMapper modelMapper ;

    @Autowired
    private UserService userService ;

    @Autowired
    private UserRepository userRepo;

    public UserDTO getUserById(Long id) {

        User user = userRepo.findById(id).orElse(null);
        if (Objects.nonNull(user)){
            return modelMapper.convertertoUserDTO(user);
        }else return null;
    }

    public User saveUser(User user) {

        return userRepo.save(user);
    }


    public List<UserDTO> findAll() {
        return converteToUserDTO(userRepo.findAll()) ;
    }

    public List<UserDTO> converteToUserDTO(List<User> users){
        return users.stream().map(modelMapper :: convertertoUserDTO).collect(Collectors.toList());
    }

}
