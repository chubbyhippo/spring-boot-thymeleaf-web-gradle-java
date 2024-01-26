package com.example.demo.application.dto;

import com.example.demo.domain.model.Gender;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserDto(
        String name,
        Gender gender,
        LocalDate birthday,
        String phoneNumber,
        String email
) {
}
