package com.atlas.management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Column(nullable = true)
    private String universityName;

    @Column(nullable = true)
    private String universityCountry;

    @Column(nullable = true)
    private String universityCity;


    @Column(nullable = true)
    private String universityEmail;

    @Column(nullable = true)
    private String universityAddress;


    @Column(nullable = true)
    private String universityWebsite;



}
