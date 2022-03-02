package com.example.dong.config;

import com.example.dong.repository.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 1:18 PM
 *
 */
@Slf4j
public class UidEntityListener {

    @PrePersist
    public void setUid(BaseEntity target) {
        log.info("保存前设置uid值");
        target.setUid("uidtestest");
    }

    @PostPersist
    public void postPersist(BaseEntity target) {
        log.info("保存后设置uid值");
        target.setUid("uidtestest");
    }

}
