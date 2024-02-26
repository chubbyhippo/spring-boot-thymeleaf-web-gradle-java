package com.example.demo.application.dto;

import com.example.demo.application.validation.UniqueEmail;
import com.example.demo.domain.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
public record RequestUserDto(
        @NotBlank
        String firstname,
        @NotBlank
        String lastname,
        @NotNull
        Gender gender,
        @Email
        @NotBlank
        @UniqueEmail
        String email,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate birthday,
        @NotBlank
        @Pattern(regexp = "[0-9.\\-() x/+]+")
        String phoneNumber
) {

}
