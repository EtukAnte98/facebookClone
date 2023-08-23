package com.example.FacebookCloneApp.Repositories;

import com.example.FacebookCloneApp.Model.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllById(int id);
}