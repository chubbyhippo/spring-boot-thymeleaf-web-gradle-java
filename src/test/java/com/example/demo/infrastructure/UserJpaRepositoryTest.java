package com.example.demo.infrastructure;

import com.example.demo.AbstractContainersTest;
import com.example.demo.domain.model.Gender;
import com.example.demo.domain.model.User;
import com.example.demo.infrastructure.repository.UserJpaRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportTestcontainers(AbstractContainersTest.class)
class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository repository;

    @Test
    @DisplayName("should save user")
    void shouldSaveUser() {
        var faker = new Faker();
        var genders = Gender.values();
        var randomGender = genders[ThreadLocalRandom.current().nextInt(genders.length)];
        var savedUser = repository.save(User.builder()
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.elderScrolls().lastName())
                .gender(randomGender)
                .email(faker.internet().emailAddress())
                .phoneNumber(String.valueOf(faker.phoneNumber()))
                .build());

        var id = savedUser.getId();
        assertThat(id).isNotNull();
    }
}