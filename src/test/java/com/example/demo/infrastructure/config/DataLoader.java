package com.example.demo.infrastructure.config;

import com.example.demo.domain.model.Gender;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadLocalRandom;
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
        log.info("JDBC URL : {}" , jdbcUrl);
        IntStream.range(0, 1000)
                .mapToObj(i -> new Faker()).map(faker -> User.builder()
                        .firstname(faker.elderScrolls().firstName())
                        .lastname(faker.touhou().characterLastName())
                        .dob(faker.date().birthdayLocalDate())
                        .email(faker.internet().emailAddress())
                        .gender(Gender.values()[ThreadLocalRandom.current().nextInt(Gender.values().length)])
                        .phoneNumber(faker.phoneNumber().phoneNumber())
                        .build())
                .forEach(userRepository::createUser);

    }
}
