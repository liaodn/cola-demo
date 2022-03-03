package com.example.dong.repository;

import com.example.dong.annotation.Uid;
import com.example.dong.config.UidEntityListener;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/2/28 9:13 AM
 *
 */
@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, UidEntityListener.class})
public abstract class BaseEntity {

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
    private Date createdDate  ;
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
    private Date lastModifiedDate;

    @Column(
            name = "uid"
    )
    @Uid
    private String uid;
}
