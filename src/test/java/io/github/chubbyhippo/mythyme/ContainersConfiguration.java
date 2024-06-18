package io.github.chubbyhippo.mythyme;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfiguration {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> getPostgresql() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
    }

}
