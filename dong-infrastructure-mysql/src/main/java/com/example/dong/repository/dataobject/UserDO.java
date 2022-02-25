package com.example.dong.repository.dataobject;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/1/25 4:07 PM
 *
 */
@Entity
@Table(name = "tb_user")
@Data
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedBy
    @Column(
            name = "created_by",
            nullable = false,
            length = 50,
            updatable = false
    )
    private String createdBy;
    @CreatedDate
    @Column(
            name = "created_date",
            nullable = false,
            updatable = false
    )
    private Date createdDate = new Date();
    @LastModifiedBy
    @Column(
            name = "last_modified_by",
            length = 50
    )
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(
            name = "last_modified_date"
    )
    private Date lastModifiedDate = new Date();
}

