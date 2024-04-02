package io.github.chubbyhippo.mythyme;

import org.springframework.boot.SpringApplication;

public class TestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.from(DemoApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }

}