package com.example.dong.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dong")
@Data
public class DongProperties {

    private String username;

    private String sex;

    private int age;
}
