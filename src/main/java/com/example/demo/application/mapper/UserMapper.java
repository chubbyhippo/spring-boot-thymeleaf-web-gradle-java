package com.example.demo.application.mapper;

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
}
