package com.example.dong.repository.dataobject;

import com.example.dong.annotation.Uid;
import com.example.dong.config.UidEntityListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/2/28 9:13 AM
 *
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, UidEntityListener.class})
@Data
@Slf4j
public abstract class BaseEntity implements Serializable {

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected LocalDateTime createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;

    @Uid
    protected String uid;

}
