package com.example.demo.application.service;

import com.example.demo.application.dto.RequestUserDto;
import com.example.demo.application.dto.ResponseUserDto;
import com.example.demo.application.mapper.UserMapper;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public Page<ResponseUserDto> getUsers(Pageable pageable) {
        return repository.getUsers(pageable)
                .map(userMapper::toResponseUserDto);
    }

    public void createUser(RequestUserDto requestUserDto) {
        repository.createUser(userMapper.toUser(requestUserDto));
    }

}
