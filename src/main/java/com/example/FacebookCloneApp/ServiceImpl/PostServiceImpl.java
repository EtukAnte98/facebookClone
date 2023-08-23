package com.example.FacebookCloneApp.ServiceImpl;

import com.example.FacebookCloneApp.DTOs.PostDTO;
import com.example.FacebookCloneApp.Model.Post;
import com.example.FacebookCloneApp.Repositories.PostRepository;
import com.example.FacebookCloneApp.Services.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findPostByUserId(int id) {
        return postRepository.findAllById(id);
    }

    @Override
    public Post savePosts(PostDTO postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        return postRepository.save(post);
    }

}
