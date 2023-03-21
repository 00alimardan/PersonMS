package com.example.personms.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person2 {
    private Long id;
    private String name;
    private String surname;
    private String patronymicName;
    private String fin;
    private Gender gender;
    private String birthDate;
    private MarriageStatus marriageStatus;
    private String nationality;
    private String address;
    private String workDetails;
    private String education;
    private LocalDateTime createdAt;
}
