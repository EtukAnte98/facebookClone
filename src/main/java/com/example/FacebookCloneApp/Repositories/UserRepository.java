package com.example.FacebookCloneApp.Repositories;

import com.example.FacebookCloneApp.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
    Users findByEmail (String email);
}