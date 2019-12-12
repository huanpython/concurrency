package com.example.huan.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 4:24
 */
public class Demo5 {
    private static int num = 0;

    //公平锁和非公平锁在程序调度上是很不一样
    private static ReentrantLock fairLock = new ReentrantLock(true);

    public static class T extends Thread {
        public T(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                fairLock.lock();
                try {
                    System.out.println(this.getName() + "获得锁!");
                } finally {
                    fairLock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        T t2 = new T("t2");
        T t3 = new T("t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
