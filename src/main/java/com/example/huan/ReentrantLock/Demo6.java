package com.example.huan.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 4:28
 */

/*
* ReentrantLock提供了另外一种可能，就是在等的获取锁的过程中（ 发起获取锁请求到还未获取到锁这段时间内 ）
* 是可以被中断的，也就是说在等待锁的过程中，程序可以根据需要取消获取锁的请求
* */

public class Demo6 {

    private static ReentrantLock lock1 = new ReentrantLock(false);
    private static ReentrantLock lock2 = new ReentrantLock(false);

    public static class T extends Thread {
        int lock;

        public T(String name, int lock) {
            super(name);
            this.lock = lock;
        }

        public void run() {
            try {
                if (this.lock == 1) {
                    lock1.lockInterruptibly();
                    TimeUnit.SECONDS.sleep(1);
                    lock2.lockInterruptibly();
                } else {
                    lock2.lockInterruptibly();
                    TimeUnit.SECONDS.sleep(1);
                    lock1.lockInterruptibly();
                }
            } catch (InterruptedException e) {
                System.out.println("中断标志:" + this.isInterrupted());
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1", 1);
        T t2 = new T("t2", 2);

        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(5);
        t2.interrupt();
    }
}
