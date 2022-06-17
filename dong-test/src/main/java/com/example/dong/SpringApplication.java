package com.example.dong;

import com.example.dong.beandefinition.Person;
import com.example.dong.beandefinition.my.Test3;
import com.example.dong.beandefinition.my.Test4;
import com.example.dong.beandefinition.my.Test5;
import com.example.dong.publisher.Publisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person p = context.getBean("test1", Person.class);
        System.out.println(p.getName());
        p = context.getBean("test2", Person.class);
        System.out.println(p.getName());

        Test3 t3 = context.getBean("test3", Test3.class);
        System.out.println(t3.getName());

        Test4 t4 = context.getBean("test4", Test4.class);
        System.out.println(t4.getName());

        Test5 t5 = context.getBean("test5", Test5.class);
        System.out.println(t5.getName());
    }

}
