package com.example.dong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

@SpringBootApplication(scanBasePackages = {"com.example.dong"})
public class FlowableStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableStartApplication.class, args);
    }

}
