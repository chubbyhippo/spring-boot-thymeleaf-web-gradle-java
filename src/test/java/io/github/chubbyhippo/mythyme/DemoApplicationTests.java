package io.github.chubbyhippo.mythyme;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThatNoException;

@SpringBootTest
@Import(ContainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
class DemoApplicationTests {

    @Test
    void shouldRunMainWithoutException() {
        final var RANDOM_PORT_NUMBER = "--server.port=0";
        assertThatNoException().isThrownBy(() -> TestDemoApplication.main(new String[]{RANDOM_PORT_NUMBER}));
    }

}
