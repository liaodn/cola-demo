package com.example.dong.domain.user;

import lombok.Data;

import java.util.Date;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 3:12 PM
 *
 */
@Data
public class User {

    private String id;

    private String username;

    private String password;

    private String email;

    private String sex;

    private String createdBy;
    private Date createdDate = new Date();
    private String lastModifiedBy;
    private Date lastModifiedDate = new Date();

}
