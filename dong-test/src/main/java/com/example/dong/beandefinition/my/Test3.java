package com.example.dong.beandefinition.my;

import com.example.dong.beandefinition.My;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/31 12:38 下午
 **/
@My
public class Test3 {

    private String name="Test3";
    private int age=12;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
