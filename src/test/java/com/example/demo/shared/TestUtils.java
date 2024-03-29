package com.example.demo.shared;

import com.example.demo.application.dto.RequestUserDto;
import com.example.demo.application.dto.ResponseUserDto;
import com.example.demo.application.mapper.UserMapper;
import com.example.demo.domain.model.Gender;
import com.example.demo.domain.model.User;
import net.datafaker.Faker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class TestUtils {
    private TestUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final Faker faker = new Faker();

    public static User createUser() {
        return User.builder()
                .id(UUID.randomUUID())
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.elderScrolls().lastName())
                .gender(Gender.values()[ThreadLocalRandom.current().nextInt(Gender.values().length)])
                .dob(faker.date().birthdayLocalDate(18, 98))
                .email(faker.internet().emailAddress())
                .phoneNumber(faker.phoneNumber().phoneNumberInternational())
                .build();

    }
    public static User createNullIdUser() {
        return User.builder()
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.elderScrolls().lastName())
                .gender(Gender.values()[ThreadLocalRandom.current().nextInt(Gender.values().length)])
                .dob(faker.date().birthdayLocalDate(18, 98))
                .email(faker.internet().emailAddress())
                .phoneNumber(faker.phoneNumber().phoneNumberInternational())
                .build();

    }

    public static RequestUserDto createCreateUserDto() {
        return RequestUserDto.builder()
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.elderScrolls().lastName())
                .gender(Gender.values()[ThreadLocalRandom.current().nextInt(Gender.values().length)])
                .birthday(faker.date().birthdayLocalDate(18, 98))
                .email(faker.internet().emailAddress())
                .phoneNumber(faker.phoneNumber().phoneNumberInternational())
                .build();

    }

    public static Page<User> createPageOfUsers() {
        return new PageImpl<>(IntStream.range(0, 10)
                .mapToObj(operand -> createUser())
                .toList());
    }

    public static Page<ResponseUserDto> createPageOfResponseDtos() {
        var UserMapper = new UserMapper();
        return createPageOfUsers().map(UserMapper::toResponseUserDto);
    }

}
