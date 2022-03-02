package com.example.dong.repository.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 4:07 PM
 *
 */

@Data
@Document("tb_user")
@EqualsAndHashCode(callSuper = false)
public class UserDO extends BaseEntity {

    @Id
    private String id;

    private String username;

    private String password;

    private String email;

    private String sex;

}

