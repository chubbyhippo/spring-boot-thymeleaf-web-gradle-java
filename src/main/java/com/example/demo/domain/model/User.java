package com.example.demo.domain.model;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Table(name = "app_user")
public record User(
        @Id
        UUID id,
        @Column("first_name")
        String firstname,
        @Column("last_name")
        String lastname,
        @Column("gender")
        Gender gender,
        @Column("date_of_birth")
        LocalDate dob,
        @Column("email")
        String email,
        @Column("phone_number")
        String phoneNumber,
        @CreatedDate
        Instant createdDate,
        @LastModifiedDate
        Instant lastModifiedDate,
        @Version
        int version
) {
}
