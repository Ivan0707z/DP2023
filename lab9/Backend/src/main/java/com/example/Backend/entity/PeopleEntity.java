package com.example.Backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="people")
public class PeopleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String photo;
}
