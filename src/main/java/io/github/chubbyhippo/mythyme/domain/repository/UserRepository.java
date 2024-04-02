package io.github.chubbyhippo.mythyme.domain.repository;

import io.github.chubbyhippo.mythyme.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {

    User createUser(User user);

    Page<User> getUsers(Pageable pageable);

    boolean existsByEmail(String email);

}
