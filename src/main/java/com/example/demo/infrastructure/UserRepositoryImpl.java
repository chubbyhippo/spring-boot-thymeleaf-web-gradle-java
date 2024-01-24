package com.example.demo.infrastructure;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
