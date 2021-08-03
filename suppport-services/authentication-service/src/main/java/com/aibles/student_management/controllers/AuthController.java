package com.aibles.student_management.controllers;


import com.aibles.student_management.common.JwtUtils;
import com.aibles.student_management.common.UserRole;
import com.aibles.student_management.dto.JwtResponse;
import com.aibles.student_management.dto.LoginRequest;
import com.aibles.student_management.dto.MessageResponse;
import com.aibles.student_management.dto.SignupRequest;
import com.aibles.student_management.entities.Role;
import com.aibles.student_management.entities.User;
import com.aibles.student_management.respositories.RoleRepository;
import com.aibles.student_management.respositories.UserRepository;
import com.aibles.student_management.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles  = userDetails.getAuthorities().stream()
                .map(item->item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getId(),userDetails.getUsername(),
                userDetails.getEmail(),userDetails.getFullName(),
                userDetails.getAddress(),userDetails.getPhone(),userDetails.getFacebookId(),roles));
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            return new ResponseEntity<>(new MessageResponse("Error: Username is already taken!"), HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return new ResponseEntity<>(new MessageResponse("Error: Email is already in use!"), HttpStatus.BAD_REQUEST);
        }
        User user = new User(signupRequest.getUsername(),encoder.encode(signupRequest.getPassword()),
                signupRequest.getFullName(),signupRequest.getAddress(),signupRequest.getPhone(),
                signupRequest.getEmail(),signupRequest.getFacebookId());

        Set<Role> roles = new HashSet<>();


        Role userRole = roleRepository.findByName(UserRole.ROLE_CUSTOMER)
                .orElseThrow(()->new RuntimeException("Error: Role is not found"));
        roles.add(userRole);

        user.setRoles(roles);
        User u = userRepository.save(user);
        Set<Role> list = u.getRoles();
        String str ="";
        for (Role r : list) {
            System.out.println(r.getName());
            str = r.getName().toString();
        }


        return ResponseEntity.ok(new MessageResponse("User registered successfully!" + str));
    }


}
