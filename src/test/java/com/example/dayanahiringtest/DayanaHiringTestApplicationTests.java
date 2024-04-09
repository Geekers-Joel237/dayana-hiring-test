package com.example.dayanahiringtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(PostgreSqlTestConfiguration.class)
class DayanaHiringTestApplicationTests {

    @Test
    void contextLoads() {
    }

}
