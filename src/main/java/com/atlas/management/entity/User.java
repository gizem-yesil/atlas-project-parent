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
    private String encryptedPassword;
    private String id;
    private String userName;
    private String userPassword;
    private String userEmail;


    public User orElse(Object o) {
        return this;
    }


}
