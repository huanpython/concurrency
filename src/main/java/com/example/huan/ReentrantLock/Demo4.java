package com.example.huan.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 4:21
 */
/*
* lock()方法和unlock()方法需要成对出现，锁了几次，也要释放几次，
* 否则后面的线程无法获取锁了；可以将add中的unlock删除一个事实，上面代码运行将无法结束
unlock()方法放在finally中执行，保证不管程序是否有异常，锁必定会释放
* */

public class Demo4 {

    private static int num = 0;
    private static ReentrantLock lock = new ReentrantLock();

    private static void add(){
        lock.lock();
        lock.lock();
        try {
            num++;
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public static class T extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                Demo4.add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        T t2 = new T();
        T t3 = new T();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(Demo4.num);
    }

}
