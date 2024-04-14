package io.github.chubbyhippo.mythyme.application.service;

import io.github.chubbyhippo.mythyme.application.dto.RequestUserDto;
import io.github.chubbyhippo.mythyme.application.dto.ResponseUserDto;
import io.github.chubbyhippo.mythyme.application.mapper.UserMapper;
import io.github.chubbyhippo.mythyme.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public UserService(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    public Page<ResponseUserDto> getUsers(Pageable pageable) {
        return repository.getUsers(pageable)
                .map(userMapper::toResponseUserDto);
    }

    public void createUser(RequestUserDto requestUserDto) {
        repository.createUser(userMapper.toUser(requestUserDto));
    }

}
