package com.example.dong.publisher;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void send(){
        System.out.println("线程ID:"+Thread.currentThread().getName()+" 发布消息");
        applicationEventPublisher.publishEvent(new OrderEvent("你好"));
        applicationEventPublisher.publishEvent(new OrderEventI("source","我也好"));
    }
}
