package com.example.dong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 *
 * @Author: 廖冬年
 * @Date: 2022/3/1 12:52 PM
 *
 */
@Configuration
@EnableMongoAuditing
public class MongoAuditingConfiguration {
}
