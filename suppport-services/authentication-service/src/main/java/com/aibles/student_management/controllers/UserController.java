package com.aibles.student_management.controllers;


import com.aibles.student_management.dto.UserDTO;
import com.aibles.student_management.respositories.UserRepository;
import com.aibles.student_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository ;
    @Autowired
    UserService userSer;

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity<?> getUserById(@RequestParam("id") Long id){
        UserDTO user = userSer.getUserById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(value="/all" ,produces = "application/json")
    public ResponseEntity<?> findAll(){
        List<UserDTO> users = userSer.findAll() ;
        return new ResponseEntity<>(users , HttpStatus.OK);
    }


}
