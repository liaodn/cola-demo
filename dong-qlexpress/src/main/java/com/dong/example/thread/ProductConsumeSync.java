package com.dong.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/9 6:41 下午
 **/
public class ProductConsumeSync {

    Object lock = new Object();
    private String input;
    private char[] c = null;
    int index = 0;
    private BlockingQueue<Character> queue = new ArrayBlockingQueue<>(10);
    public void execute(String input ) throws InterruptedException {
        this.input = input;
        c = input.toCharArray();
        index=0;
        Product product = new Product("生产者",input);

        //控制两个线程 控制台输出 AABBB
        MyThread a  = new MyThread("A线程",'A');
        MyThread b  = new MyThread("B线程",'B');
        a.start();
        b.start();
        product.setDaemon(true);
        product.start();
        product.join();
    }

    class Product extends Thread {

       private String input;
       private char[] data;

        public Product(String name,String input) {
            super(name);
            this.input = input;
            this.data = input.toCharArray();
        }

        @Override
        public void run() {
            for (int i = 0; i < this.data.length; i++) {
                try {
                    queue.put(data[i]);
                    sleep(100);
//                    System.out.print("生产"+data[i]+"-");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
                try {
                    Character result = queue.peek();
                    if (result!=null && flag==result){
                        result = queue.take();
                        System.out.print(result);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
