package io.github.chubbyhippo.demo.shared;

import io.github.chubbyhippo.demo.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

@Configuration
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        IntStream.range(0, 1000)
                .mapToObj(i -> TestUtils.createNullIdUser())
                .forEach(userRepository::createUser);

    }
}
