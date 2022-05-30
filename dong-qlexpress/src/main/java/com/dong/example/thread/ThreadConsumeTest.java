package com.dong.example.thread;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/9 6:41 下午
 **/
public class ThreadConsumeTest {

    Object lock = new Object();

    String input="AABBBABBBAAA";
    char[] c = input.toCharArray();

    int index = 0;
    Thread produce = new Thread("生产者"){
        @Override
        public void run() {
            while (index<c.length){
                synchronized (lock) {
                    try {
                        lock.notify();
                        lock.wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }
    };
    Thread consume = new Thread("消费者"){
        @Override
        public void run() {
            while (index<c.length){
                synchronized (lock){
                    try {
                        Thread.sleep(10);
                        lock.notify();
                        System.out.println(Thread.currentThread().getName()+":"+c[index]);
                        index++;
                        if (index<c.length){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    Thread consume2 = new Thread("消费者2"){
        @Override
        public void run() {
            while (index<c.length){
                synchronized (lock){
                    try {
                        Thread.sleep(10);
                        lock.notify();
                        System.out.println(Thread.currentThread().getName()+":"+c[index]);
                        index++;
                        if (index<c.length){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public void test(){
        //控制两个线程 控制台输出 AABBB
        consume.start();
        consume2.start();
        produce.start();
    }

    public static void main(String[] args) {
       new ThreadConsumeTest().test();
    }


}
