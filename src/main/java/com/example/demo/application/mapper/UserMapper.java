package com.example.demo.application.mapper;

import com.example.demo.application.dto.RequestUserDto;
import com.example.demo.application.dto.ResponseUserDto;
import com.example.demo.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public ResponseUserDto toResponseUserDto(User user) {
        return ResponseUserDto.builder()
                .name(user.firstname() + " " + user.lastname())
                .gender(user.gender())
                .birthday(user.dob())
                .phoneNumber(user.phoneNumber())
                .email(user.email())
                .build();
    }

    public User toUser(RequestUserDto requestUserDto) {
        return User.builder()
                .firstname(requestUserDto.firstname())
                .lastname(requestUserDto.lastname())
                .gender(requestUserDto.gender())
                .dob(requestUserDto.birthday())
                .email(requestUserDto.email())
                .phoneNumber(requestUserDto.phoneNumber())
                .build();
    }
}
