package com.example.FacebookCloneApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userid;
    @ManyToOne
    private Comment comment;
}
