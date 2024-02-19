package com.example.demo.application.mapper;

import com.example.demo.shared.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Spy
    private UserMapper userMapper;

    @Test
    @DisplayName("should return response user dto")
    void shouldReturnResponseUserDto() {
        var user = TestUtils.createUser();

        var responseUserDto = userMapper.toResponseUserDto(user);
        assertThat(responseUserDto.name()).isEqualTo(user.getFirstname() + " " + user.getLastname());
        assertThat(responseUserDto.gender()).isEqualTo(user.getGender());
        assertThat(responseUserDto.birthday()).isEqualTo(user.getDob());
        assertThat(responseUserDto.phoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(responseUserDto.email()).isEqualTo(user.getEmail());

    }

    @Test
    @DisplayName("should return user from create user dto")
    void shouldReturnUserFromCreateUserDto() {
        var createUserDto = TestUtils.createCreateUserDto();
        var user = userMapper.toUser(createUserDto);

        assertThat(user.getFirstname()).isEqualTo(createUserDto.firstname());
        assertThat(user.getLastname()).isEqualTo(createUserDto.lastname());
        assertThat(user.getGender()).isEqualTo(createUserDto.gender());
        assertThat(user.getEmail()).isEqualTo(createUserDto.email());
        assertThat(user.getDob()).isEqualTo(createUserDto.birthday());
        assertThat(user.getPhoneNumber()).isEqualTo(createUserDto.phoneNumber());

    }

}