package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "thymeleaf_user")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "date_of_birth")
    private LocalDate dob;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

}
