package com.example.demo;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.model.Gender;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        var faker = new Faker();
        User user = User.builder()
                .firstname(faker.elderScrolls().firstName())
                .lastname(faker.touhou().characterLastName())
                .dob(faker.date().birthdayLocalDate())
                .email(faker.internet().emailAddress())
                .gender(Gender.UNKNOWN)
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .build();
        userRepository.createUser(user);
    }
}
