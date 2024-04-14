package io.github.chubbyhippo.mythyme.application.mapper;

import io.github.chubbyhippo.mythyme.application.dto.RequestUserDto;
import io.github.chubbyhippo.mythyme.application.dto.ResponseUserDto;
import io.github.chubbyhippo.mythyme.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public ResponseUserDto toResponseUserDto(User user) {
        return ResponseUserDto.ResponseUserDtoBuilder.aResponseUserDto()
                .withName(user.firstname() + " " + user.lastname())
                .withGender(user.gender())
                .withBirthday(user.dob())
                .withPhoneNumber(user.phoneNumber())
                .withEmail(user.email())
                .build();
    }

    public User toUser(RequestUserDto requestUserDto) {
        return User.UserBuilder.anUser()
                .withId(requestUserDto.id())
                .withFirstname(requestUserDto.firstname())
                .withLastname(requestUserDto.lastname())
                .withGender(requestUserDto.gender())
                .withDob(requestUserDto.birthday())
                .withEmail(requestUserDto.email())
                .withPhoneNumber(requestUserDto.phoneNumber())
                .build();
    }
}
