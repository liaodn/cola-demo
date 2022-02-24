package com.example.dong.repository.dataobject;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 4:07 PM
 *
 */
@Entity
@Table(name = "tb_user")
@Data
public class UserDO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "username", unique = false, nullable = false, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "sex", length = 64)
    private String sex;

}

