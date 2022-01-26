package com.example.dong.repository.dataobject;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 4:07 PM
 *
 */

@Data
@Document("tb_user")
public class UserDO {

    @Id
    private String id;

    private String username;

    private String password;

    private String email;

    private String sex;
}

