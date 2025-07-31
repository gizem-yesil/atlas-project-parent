package com.atlas.management.entity;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String userName;
    private String userEmail;

    // Parametresiz constructor (varsa, kalabilir)
    public UserDto() {}

    // 3 parametreli constructor ekle:
    public UserDto(String id, String userName, String userEmail) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Getter-Setter'lar...
}