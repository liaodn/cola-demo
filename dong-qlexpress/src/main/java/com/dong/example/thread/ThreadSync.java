package com.dong.example.thread;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/9 6:41 下午
 **/
public class ThreadSync {

    Object lock = new Object();
    private List<Character> input;
    int index = 0;
    public void execute(List<Character> input){
        this.input = input;
        index=0;
        //控制两个线程 控制台输出 AABBB
        MyThread a  = new MyThread("A线程",'A');
        MyThread b  = new MyThread("B线程",'B');
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyThread extends Thread{

        private char flag;

        public MyThread(String name, char flag) {
            super(name);
            this.flag = flag;
        }

        @Override
        public void run() {
            while (true){
                synchronized (lock){
                    try {
                        if (index>=input.size()){
                            lock.notify();
                            break;
                        }
                        if (input.get(index)==flag){
                            System.out.print(flag);
                            index++;
                        }else {
                            lock.notify();
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
