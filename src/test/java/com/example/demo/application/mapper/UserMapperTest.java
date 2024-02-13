package com.example.demo.application.mapper;

import com.example.demo.shared.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Spy
    private UserMapper userMapper;

    @Test
    @DisplayName("should return response user dto")
    void shouldReturnResponseUserDto() {
        var user = TestUtils.createUser();

        var responseUserDto = userMapper.toResponseUserDto(user);
        assertEquals(user.getFirstname() + " " + user.getLastname(), responseUserDto.name());
        assertEquals(user.getGender(), responseUserDto.gender());
        assertEquals(user.getDob(), responseUserDto.birthday());
        assertEquals(user.getPhoneNumber(), responseUserDto.phoneNumber());
        assertEquals(user.getEmail(), responseUserDto.email());
    }

}