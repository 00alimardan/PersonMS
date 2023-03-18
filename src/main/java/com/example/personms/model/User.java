package com.example.personms.model;

import com.example.personms.entity.PersonEntity;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String username;
    private String password;
    private String number;
    private String pin;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private PersonEntity person;
}
