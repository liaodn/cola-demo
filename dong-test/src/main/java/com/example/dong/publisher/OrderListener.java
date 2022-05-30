package com.example.dong.publisher;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @EventListener
    public void process(OrderEvent event){
        System.out.println("线程ID:"+Thread.currentThread().getName()+"收到订单消息"+event.getMsg());
    }
}
