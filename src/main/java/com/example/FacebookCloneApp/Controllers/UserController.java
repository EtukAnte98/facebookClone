package com.example.FacebookCloneApp.Controllers;

import com.example.FacebookCloneApp.DTOs.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/user")
@Slf4j
public class UserController {
    @GetMapping("/user")
    public ModelAndView fetchUserProfile(){
        log.info("UserCONTROLLER CLASS = User id");
        return new ModelAndView("Dashboard").addObject("post", new PostDTO());
    }
}
