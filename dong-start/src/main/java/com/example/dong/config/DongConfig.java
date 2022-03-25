package com.example.dong.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DongProperties.class)
@ConditionalOnProperty(name = "dong.enable", havingValue = "true", matchIfMissing = false)
public class DongConfig {

}
