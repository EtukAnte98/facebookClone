package com.example.FacebookCloneApp.ServiceImpl;

import com.example.FacebookCloneApp.DTOs.SignUpDTO;
import com.example.FacebookCloneApp.Repositories.UserRepository;
import com.example.FacebookCloneApp.Services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FacebookCloneApp.Model.Users;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public Users addUser(SignUpDTO signUpDTO){
        signUpDTO.setPassword(BCrypt.hashpw(signUpDTO.getPassword(),BCrypt.gensalt()));
        return userRepository.save(new Users(signUpDTO));
    }

    @Override
    public Users findById(int id) {
        return userRepository.findById("id").orElseThrow(()-> new NullPointerException("User not found with id" +id));
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public  Users findByEmailAndPassword(String email, String password){
        Users users;
        users = userRepository.findByEmail(email);
        if(users == null){
            return users;
        }
        if(BCrypt.checkpw(password, users.getPassword())){
            return users;
        }
        users = null;
        return users;
    }
}

