package io.github.chubbyhippo.mythyme.application.dto;

import io.github.chubbyhippo.mythyme.domain.model.Gender;
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
