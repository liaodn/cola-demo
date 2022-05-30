package com.example.dong.publisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListenerI implements ApplicationListener<OrderEventI> {
    @Override
    public void onApplicationEvent(OrderEventI event) {
        System.out.println("线程ID:"+Thread.currentThread().getName()+"接口收到订单消息"+event.getMsg());
    }
}
