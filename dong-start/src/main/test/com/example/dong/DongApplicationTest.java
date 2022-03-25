package com.example.dong;

import com.example.dong.domain.Person;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class DongApplicationTest {

    public static void main(String[] args) {
        Field field = ReflectionUtils.findField(Person.class, "username");
//        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.makeAccessible(field);
        Person p = new Person("你好", 11);
        String username = (String) ReflectionUtils.getField(field, p);
        System.out.println(username);

        ReflectionUtils.setField(field, p, "你是谁");


        System.out.println(p.getUsername());
    }
}
