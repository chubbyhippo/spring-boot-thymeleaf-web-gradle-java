package com.example.demo.infrastructure;

import com.example.demo.AbstractContainersTest;
import com.example.demo.infrastructure.repository.UserJpaRepository;
import com.example.demo.shared.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportTestcontainers(AbstractContainersTest.class)
class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository repository;

    @Test
    @DisplayName("should save user")
    void shouldSaveUser() {
        var savedUser = repository.save(TestUtil.createUser());
        var id = savedUser.getId();

        assertThat(id).isNotNull();
    }
}