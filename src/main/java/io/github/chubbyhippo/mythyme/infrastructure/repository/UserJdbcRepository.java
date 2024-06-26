package io.github.chubbyhippo.mythyme.infrastructure.repository;

import io.github.chubbyhippo.mythyme.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserJdbcRepository extends CrudRepository<User, UUID>, PagingAndSortingRepository<User, UUID> {
    boolean existsByEmail(String email);
}
