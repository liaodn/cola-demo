package com.example.dong;

import com.example.dong.publisher.Publisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean("publisher", Publisher.class).send();
    }

}
