package com.example.demo.application.service;

import com.example.demo.application.mapper.UserMapper;
import com.example.demo.domain.model.Gender;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Spy
    private UserMapper userMapper;
    @InjectMocks
    private UserService userService;


    @Test
    @DisplayName("should get users")
    void shouldGetUsers() {

        var faker = new Faker();
        var genders = Gender.values();
        var randomGender = genders[ThreadLocalRandom.current().nextInt(genders.length)];
        var user = User.builder()
                .id(UUID.randomUUID())
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.elderScrolls().lastName())
                .gender(randomGender)
                .email(faker.internet().emailAddress())
                .phoneNumber(String.valueOf(faker.phoneNumber()))
                .build();

        when(userRepository.getUsers(any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(user)));
        var result = userService.getUsers(PageRequest.of(0, 2));

        assertThat(result.getContent()).hasSize(1);
    }
}