package com.example.FacebookCloneApp.Services;

import com.example.FacebookCloneApp.DTOs.PostDTO;
import com.example.FacebookCloneApp.Model.Post;

import java.util.List;

public interface PostService {
    List<Post> findPostByUserId (int id);

    Post savePosts(PostDTO postsDTO);
}
