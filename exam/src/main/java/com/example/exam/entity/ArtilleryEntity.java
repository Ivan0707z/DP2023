package com.example.exam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="artillery")
public class ArtilleryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String photo;
    public int power;
    public int price;
}
