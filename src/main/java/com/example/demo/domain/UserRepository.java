package com.example.demo.domain;

import com.example.demo.domain.model.User;

public interface UserRepository {

    User save(User user);
}
