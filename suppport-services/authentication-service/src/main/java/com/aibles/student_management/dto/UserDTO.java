package com.aibles.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id ;
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String facebookId;

}
