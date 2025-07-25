package com.atlas.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "users")
public class User {
    @Id
    private String id;
    private String userName;
    private String userPassword;
    private String userEmail;


}
