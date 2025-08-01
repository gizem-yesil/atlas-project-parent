package com.atlas.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Column(nullable = true)
    private String userName;

    @Column(nullable = false)
    private String userPassword; // Bcrypt ile hashlenecek

    @Column(nullable = false)
    private String userEmail;

    @Enumerated(EnumType.STRING)
    private Role role;
}
