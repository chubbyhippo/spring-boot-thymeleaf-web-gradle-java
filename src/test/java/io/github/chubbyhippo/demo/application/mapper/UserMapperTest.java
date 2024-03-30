package io.github.chubbyhippo.demo.application.mapper;

import io.github.chubbyhippo.demo.shared.TestUtils;
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
        assertThat(responseUserDto.name()).isEqualTo(user.firstname() + " " + user.lastname());
        assertThat(responseUserDto.gender()).isEqualTo(user.gender());
        assertThat(responseUserDto.birthday()).isEqualTo(user.dob());
        assertThat(responseUserDto.phoneNumber()).isEqualTo(user.phoneNumber());
        assertThat(responseUserDto.email()).isEqualTo(user.email());

    }

    @Test
    @DisplayName("should return user from create user dto")
    void shouldReturnUserFromCreateUserDto() {
        var createUserDto = TestUtils.createCreateUserDto();
        var user = userMapper.toUser(createUserDto);

        assertThat(user.firstname()).isEqualTo(createUserDto.firstname());
        assertThat(user.lastname()).isEqualTo(createUserDto.lastname());
        assertThat(user.gender()).isEqualTo(createUserDto.gender());
        assertThat(user.email()).isEqualTo(createUserDto.email());
        assertThat(user.dob()).isEqualTo(createUserDto.birthday());
        assertThat(user.phoneNumber()).isEqualTo(createUserDto.phoneNumber());

    }

}