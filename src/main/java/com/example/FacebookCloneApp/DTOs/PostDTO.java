package com.example.FacebookCloneApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.FacebookCloneApp.Model.Users;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
    private String content;
    private List<CommentDTO> comments;
    private Users user;
}
