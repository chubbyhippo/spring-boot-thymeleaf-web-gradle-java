package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {

    User createUser(User user);

    Page<User> getUsers(Pageable pageable);

}
