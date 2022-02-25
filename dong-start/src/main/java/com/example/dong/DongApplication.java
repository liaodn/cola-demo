package com.example.dong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongApplication.class, args);
    }

}
