package com.example.dong;

import com.example.dong.beandefinition.MyBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(MyBeanDefinitionRegistrar.class)
public class AppConfig {
}
