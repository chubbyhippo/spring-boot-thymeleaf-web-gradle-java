package com.example.demo.application.service;

import com.example.demo.application.mapper.UserMapper;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.shared.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


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
        when(userRepository.getUsers(any(Pageable.class)))
                .thenReturn(TestUtils.createPageOfUsers());
        var result = userService.getUsers(PageRequest.of(0, 2));

        assertThat(result.getContent()).isNotNull();
    }

    @Test
    @DisplayName("should create user")
    void shouldCreateUser() {
        when(userRepository.createUser(any(User.class))).thenReturn(TestUtils.createUser());
        userService.createUser(TestUtils.createCreateUserDto());
        verify(userRepository, times(1)).createUser(any(User.class));
    }
}