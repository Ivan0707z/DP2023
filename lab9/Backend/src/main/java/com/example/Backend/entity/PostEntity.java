package com.example.Backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String start;
    public String endd;
    public Boolean status;
}
