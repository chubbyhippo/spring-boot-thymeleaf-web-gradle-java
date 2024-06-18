package io.github.chubbyhippo.mythyme.infrastructure;

import io.github.chubbyhippo.mythyme.ContainersConfiguration;
import io.github.chubbyhippo.mythyme.domain.model.User;
import io.github.chubbyhippo.mythyme.infrastructure.repository.UserJdbcRepository;
import io.github.chubbyhippo.mythyme.infrastructure.repository.UserRepositoryImpl;
import io.github.chubbyhippo.mythyme.shared.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ContainersConfiguration.class)
class UserRepositoryTest {

    @Mock
    private UserJdbcRepository userJdbcRepository;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @Test
    @DisplayName("should save user")
    void shouldSaveUser() {

        when(userJdbcRepository.save(any(User.class))).thenReturn(TestUtils.createUser());
        var savedUser = userRepository.createUser(TestUtils.createUser());
        var id = savedUser.id();

        assertThat(id).isNotNull();
    }

    @Test
    @DisplayName("should get page of users")
    void shouldGetPageOfUsers() {
        when(userJdbcRepository.findAll(any(Pageable.class))).thenReturn(TestUtils.createPageOfUsers());
        var pageRequest = PageRequest.of(0, 2);
        var users = userRepository.getUsers(pageRequest);

        assertThat(users.getTotalElements()).isPositive();
    }

    @Test
    @DisplayName("should get existing state of email")
    void shouldGetExistingStateOfEmail() {
        when(userJdbcRepository.existsByEmail(any(String.class))).thenReturn(true);
        var email = TestUtils.createUser().email();
        assertThat(userRepository.existsByEmail(email)).isTrue();
    }
}