package com.atlas.management.entity;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String userName;
    private String userEmail;


    public UserDto() {}


    public UserDto(String id, String userName, String userEmail) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
    }

}