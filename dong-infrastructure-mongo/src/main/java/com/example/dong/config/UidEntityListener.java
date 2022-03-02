package com.example.dong.config;

import com.example.dong.repository.dataobject.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 1:18 PM
 * 这个在mongo 上不生效
 */
@Slf4j
public class UidEntityListener {

    @PrePersist
    public void setUid(Object target) {
        log.info("保存前设置uid值");
//        baseEntity.setUid("uidtestest");
    }

    @PostPersist
    public void postPersist(BaseEntity baseEntity) {
        log.info("保存后设置uid值");
//        baseEntity.setUid("uidtestest");
    }

}
