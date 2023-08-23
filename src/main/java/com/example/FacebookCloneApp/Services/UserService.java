package com.example.FacebookCloneApp.Services;

import com.example.FacebookCloneApp.DTOs.SignUpDTO;
import com.example.FacebookCloneApp.Model.Users;

public interface UserService{
    Users addUser (SignUpDTO signUpDTO);
    Users findById(int id);
    Users findByEmail(String email);
    Users findByEmailAndPassword(String email, String password);
}