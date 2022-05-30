package com.example.dong.publisher;

import org.springframework.context.ApplicationEvent;

public class OrderEvent {

    private String msg;

    public OrderEvent(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
