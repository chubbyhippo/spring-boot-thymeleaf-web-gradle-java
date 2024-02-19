package com.example.demo.application.mapper;

import com.example.demo.application.dto.CreateUserDto;
import com.example.demo.application.dto.ResponseUserDto;
import com.example.demo.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public ResponseUserDto toResponseUserDto(User user) {
        return ResponseUserDto.builder()
                .name(user.getFirstname() + " " + user.getLastname())
                .gender(user.getGender())
                .birthday(user.getDob())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }

    public User toUser(CreateUserDto createUserDto) {
        return User.builder()
                .firstname(createUserDto.firstname())
                .lastname(createUserDto.lastname())
                .gender(createUserDto.gender())
                .dob(createUserDto.birthday())
                .email(createUserDto.email())
                .phoneNumber(createUserDto.phoneNumber())
                .build();
    }
}
