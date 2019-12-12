package com.example.huan.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 4:17
 */

//https://www.tuicool.com/articles/Jvqma2F

/*
* ReentrantLock的使用过程：
创建锁：ReentrantLock lock = new ReentrantLock();
获取锁：lock.lock()
释放锁：lock.unlock();
* */

public class Demo3 {

    private static int num = 0;

    private static ReentrantLock lock = new ReentrantLock();

    private static void add(){
        lock.lock();
        try {
            num++;
        }finally {
            lock.unlock();
        }
    }

    public static class T extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                Demo3.add();
            }
        }
    }

    public static void main(String[] args)throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(Demo3.num);
    }

}
