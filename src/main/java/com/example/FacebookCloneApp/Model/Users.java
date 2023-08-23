package com.example.FacebookCloneApp.Model;

import com.example.FacebookCloneApp.DTOs.SignUpDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "User_table")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String gender;
    @Column
    String dob;
    @Column
    String email;
    @Column
    String password;

    public Users(SignUpDTO signUpDTO){
        this.firstName = signUpDTO.getFirstname();
        this.lastName = signUpDTO.getLastname();
        this.gender = signUpDTO.getGender();
        this.dob = signUpDTO.getDob();
        this.email = signUpDTO.getEmail();
        this.password = signUpDTO.getPassword();
    }
}
