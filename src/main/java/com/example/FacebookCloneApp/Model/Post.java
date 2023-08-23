package com.example.FacebookCloneApp.Model;

import com.example.FacebookCloneApp.DTOs.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    @ManyToOne
    private Users user;

    public Post (PostDTO postDTO){
        this.content = postDTO.getContent();
        this.user = postDTO.getUser();
    }
}
