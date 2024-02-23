package com.example.demo.shared;

import com.example.demo.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(DataLoader.class);

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Override
    public void run(String... args) {
        log.info("JDBC URL : {}", jdbcUrl);
        IntStream.range(0, 10)
                .mapToObj(i -> TestUtils.createUser())
                .forEach(userRepository::createUser);

    }
}
