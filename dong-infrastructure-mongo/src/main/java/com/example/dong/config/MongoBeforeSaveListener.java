package com.example.dong.config;

import com.example.dong.repository.dataobject.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 11:54 AM
 *
 */
@Component
@Order(2)
@Slf4j
public class MongoBeforeSaveListener implements ApplicationListener<BeforeSaveEvent<?>> {

    @Override
    public void onApplicationEvent(@NonNull BeforeSaveEvent<?> event) {
        Document document = event.getDocument();
        if (event.getSource() instanceof BaseEntity && document != null) {
            log.info("mongo 保存事件 ApplicationListener");
            //id为空时自动注入ID、租户ID
            document.putIfAbsent("_id", System.currentTimeMillis());
            document.put("username", "年冬廖");
        }
    }
}
