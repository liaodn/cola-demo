package com.example.dong.config;

import com.example.dong.repository.dataobject.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/2 11:40 AM
 *
 */
@Configuration
@Slf4j
public class MongoDBListenersConfig {

    @EventListener(BeforeSaveEvent.class)
    @Order(3)
    public void beforeSaveEventHandler(BeforeSaveEvent<?> event) {
        Document document = event.getDocument();
        if (event.getSource() instanceof BaseEntity && document != null) {
            log.info("mongo 保存事件");
            document.putIfAbsent("_id", System.currentTimeMillis());
            document.put("sex", "girl");
        }
    }
}
