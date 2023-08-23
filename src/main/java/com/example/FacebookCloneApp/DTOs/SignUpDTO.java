package com.example.FacebookCloneApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDTO {
    private String firstname;
    private String lastname;
    private String gender;
    private String dob;
    private String email;
    private String password;
}
