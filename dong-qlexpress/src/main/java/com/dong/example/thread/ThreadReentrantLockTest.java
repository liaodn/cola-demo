package com.dong.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/9 6:41 下午
 **/
public class ThreadReentrantLockTest {

    ReentrantLock lock = new ReentrantLock();
    Condition aCon = lock.newCondition();
    Condition bCon = lock.newCondition();
    String input="AABBBABBBAAA";
    char[] c = input.toCharArray();

    public static int index = 0;

    Thread a = new Thread("A线程"){
        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    if (index>=c.length){
                        bCon.signal();
                        break;
                    }

                    if (c[index]=='A'){
                        System.out.println(Thread.currentThread().getName()+":A");
                        index++;
                    }else {
                        bCon.signal();
                        aCon.await();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }
    };
    Thread b = new Thread("B线程"){
        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    if (index>=c.length){
                        bCon.signal();
                        break;
                    }

                    if (c[index]=='B'){
                        System.out.println(Thread.currentThread().getName()+":B");
                        index++;
                    }else {
                        aCon.signal();
                        bCon.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    };

    public void test(){
        //控制两个线程 控制台输出 AABBB
        a.start();
        b.start();
    }

    public static void main(String[] args) {
       new ThreadReentrantLockTest().test();
    }


}
