package com.example.dong.dto.clientobject;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 5:01 PM
 *
 */
public class UserCO {
    private String id;

    private String username;

    private String password;

    private String email;

    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
