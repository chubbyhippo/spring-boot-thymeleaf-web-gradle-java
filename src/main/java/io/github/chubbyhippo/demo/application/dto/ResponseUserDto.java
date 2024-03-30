package io.github.chubbyhippo.demo.application.dto;

import io.github.chubbyhippo.demo.domain.model.Gender;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ResponseUserDto(
        String name,
        Gender gender,
        LocalDate birthday,
        String phoneNumber,
        String email
) {
}
