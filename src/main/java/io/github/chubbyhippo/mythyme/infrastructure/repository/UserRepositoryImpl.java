package io.github.chubbyhippo.mythyme.infrastructure.repository;

import io.github.chubbyhippo.mythyme.domain.model.User;
import io.github.chubbyhippo.mythyme.domain.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJdbcRepository repository;

    public UserRepositoryImpl(UserJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

}
