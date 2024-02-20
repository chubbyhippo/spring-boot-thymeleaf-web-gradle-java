package com.example.demo.infrastructure;

import com.example.demo.AbstractContainersTest;
import com.example.demo.domain.model.User;
import com.example.demo.infrastructure.repository.UserJpaRepository;
import com.example.demo.infrastructure.repository.UserRepositoryImpl;
import com.example.demo.shared.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportTestcontainers(AbstractContainersTest.class)
class UserRepositoryTest {

    @Mock
    private UserJpaRepository userJpaRepository;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @Test
    @DisplayName("should save user")
    void shouldSaveUser() {

        when(userJpaRepository.save(any(User.class))).thenReturn(TestUtils.createUser());
        var savedUser = userRepository.createUser(TestUtils.createUser());
        var id = savedUser.getId();

        assertThat(id).isNotNull();
    }

    @Test
    @DisplayName("should get page of users")
    void shouldGetPageOfUsers() {
        when(userJpaRepository.findAll(any(Pageable.class))).thenReturn(TestUtils.createPageOfUsers());
        var pageRequest = PageRequest.of(0, 2);
        var users = userRepository.getUsers(pageRequest);

        assertThat(users.getTotalElements()).isPositive();
    }

    @Test
    @DisplayName("should get existing state of email")
    void shouldGetExistingStateOfEmail() {
        when(userJpaRepository.existsByEmail(any(String.class))).thenReturn(true);
        var email = TestUtils.createUser().getEmail();
        assertThat(userRepository.existsByEmail(email)).isTrue();
    }
}