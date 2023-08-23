package com.example.FacebookCloneApp.Controllers;

import com.example.FacebookCloneApp.DTOs.PostDTO;
import com.example.FacebookCloneApp.Model.Post;
import com.example.FacebookCloneApp.Model.Users;
import com.example.FacebookCloneApp.Services.PostService;
import com.example.FacebookCloneApp.Services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;




@Controller
@Slf4j
public class PostController {
    private PostService postService;
@Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/post")
    public ModelAndView viewPosts(@PathVariable("id") int id){
        List<Post> postList = postService.findPostByUserId(id);
        return new ModelAndView("Dashboard").addObject("postList", postList);
    }

    @PostMapping("/posts")
    public ModelAndView savePost(PostDTO postDTO, HttpSession session){
        Users user = (Users) session.getAttribute("users");
        postDTO.setUser(user);
        log.error(String.valueOf(postDTO));
        postService.savePosts(postDTO);
        List<Post> postList =  postService.findPostByUserId((postDTO.getUser().getId()));
        log.info(" Here is this users post: "+ postList);
        return new ModelAndView("Dashboard")
                .addObject("postList", postList)
                .addObject("post", new Post());
    }
}
