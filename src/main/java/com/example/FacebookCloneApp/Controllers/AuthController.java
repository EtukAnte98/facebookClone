package com.example.FacebookCloneApp.Controllers;

import com.example.FacebookCloneApp.DTOs.LoginDTO;
import com.example.FacebookCloneApp.DTOs.PostDTO;
import com.example.FacebookCloneApp.DTOs.SignUpDTO;
import com.example.FacebookCloneApp.Model.Users;
import com.example.FacebookCloneApp.Services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("/login")
@Slf4j
public class AuthController {
    private UserService userService;
    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/")
    public ModelAndView loginPage(){
        return new ModelAndView("index")
                .addObject("login", new LoginDTO());
    }

    @GetMapping("/Sign-up")
    public ModelAndView signUp(){
        return new ModelAndView("Sign-up")
                .addObject("signUpForm", new SignUpDTO());
    }

    @PostMapping("/Sign")
    public ModelAndView signUp(SignUpDTO signUpDTO){
        Users user = userService.addUser(signUpDTO);
        if(user != null){
            return new ModelAndView("index")
                    .addObject("login", new LoginDTO())
                    .addObject("Message","Sign up is successful, please login");

        }
        return new ModelAndView("Sign-up")
                .addObject("SignUpForm", new SignUpDTO());
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password){
        Users user = userService.findByEmailAndPassword(email, password);
        if(user != null){
            return "Dashboard";
        }
        else {
            return "redirect:/";
        }
    }

}