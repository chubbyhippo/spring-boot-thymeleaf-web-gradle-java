package io.github.chubbyhippo.mythyme.shared;

import io.github.chubbyhippo.mythyme.application.dto.RequestUserDto;
import io.github.chubbyhippo.mythyme.application.dto.ResponseUserDto;
import io.github.chubbyhippo.mythyme.application.mapper.UserMapper;
import io.github.chubbyhippo.mythyme.domain.model.Gender;
import io.github.chubbyhippo.mythyme.domain.model.User;
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

    public static RequestUserDto createRequestUserDto() {
        return RequestUserDto.RequestUserDtoBuilder.aRequestUserDto()
                .withId(UUID.randomUUID())
                .withFirstname(faker.elderScrolls().firstName())
                .withLastname(faker.elderScrolls().lastName())
                .withGender(Gender.values()[ThreadLocalRandom.current().nextInt(Gender.values().length)])
                .withBirthday(faker.date().birthdayLocalDate(18, 98))
                .withEmail(faker.internet().emailAddress())
                .withPhoneNumber(faker.phoneNumber().phoneNumberInternational())
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
