package com.example.demo.infrastructure;

import com.example.demo.domain.Gender;
import com.example.demo.domain.User;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository repository;

    @Test
    @DisplayName("should save user")
    void shouldSaveUser() {
        var faker = new Faker();
        var genders = Gender.values();
        var randomGender = genders[new Random().nextInt(genders.length)];
        var savedUser = repository.save(User.builder()
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.elderScrolls().lastName())
                .gender(randomGender)
                .email(faker.internet().emailAddress())
                .phoneNumber(String.valueOf(faker.phoneNumber()))
                .build());

        UUID id = savedUser.getId();
        System.out.println("Saved UUID :" + id);
        assertThat(id).isNotNull();
    }
}