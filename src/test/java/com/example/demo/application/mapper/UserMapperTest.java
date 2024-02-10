package com.example.demo.application.mapper;

import com.example.demo.domain.model.Gender;
import com.example.demo.domain.model.User;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Spy
    private UserMapper userMapper;

    @Test
    @DisplayName("should return response user dto")
    void shouldReturnResponseUserDto() {
        var faker = new Faker();
        var user = User.builder()
                .id(UUID.randomUUID())
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.elderScrolls().lastName())
                .gender(Gender.values()[ThreadLocalRandom.current().nextInt(Gender.values().length)])
                .dob(faker.date().birthdayLocalDate())
                .email(faker.internet().emailAddress())
                .phoneNumber(faker.phoneNumber().toString())
                .build();

        var responseUserDto = userMapper.toResponseUserDto(user);
        assertEquals(user.getFirstname() + " " + user.getLastname(), responseUserDto.name());
        assertEquals(user.getGender(), responseUserDto.gender());
        assertEquals(user.getDob(), responseUserDto.birthday());
        assertEquals(user.getPhoneNumber(), responseUserDto.phoneNumber());
        assertEquals(user.getEmail(), responseUserDto.email());
    }

}