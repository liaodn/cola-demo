package com.dong.example.thread;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/9 6:41 下午
 **/
public class ProductConsumeDubleSync {

    int index = 0;
    private BlockingQueue<Character> aQueue = new ArrayBlockingQueue<>(2);
    private BlockingQueue<Character> bQueue = new ArrayBlockingQueue<>(2);
    public void execute(List<Character> input ) throws InterruptedException {
        index=0;
        Product product = new Product("生产者",input,aQueue,bQueue);

        //控制两个线程 控制台输出 AABBB
        MyThread a  = new MyThread("A线程",aQueue);
        MyThread b  = new MyThread("B线程",bQueue);
        a.start();
        b.start();
        product.setDaemon(true);
        product.start();
        product.join();
    }

    class Product extends Thread {

       private List<Character> input;
       private BlockingQueue<Character> aQueue;
       private BlockingQueue<Character> bQueue;

        public Product( String name,List<Character> input,BlockingQueue<Character> aQueue,BlockingQueue<Character> bQueue) {
            super(name);
            this.input = input;
            this.aQueue = aQueue;
            this.bQueue = bQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < input.size(); i++) {
                try {
                    if (input.get(i)=='A'){
                        aQueue.put(input.get(i));
                    }else {
                        bQueue.put(input.get(i));
                    }
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyThread extends Thread{

        private BlockingQueue<Character> queue;

        public MyThread(String name, BlockingQueue<Character> queue) {
            super(name);
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Character result = queue.take();
                    System.out.print(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
