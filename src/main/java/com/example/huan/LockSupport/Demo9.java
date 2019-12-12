package com.example.huan.LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 3:09
 */

/*
* LockSupport.park方法让线程等待之后，唤醒方式有2种：
调用LockSupport.unpark方法
调用等待线程的 interrupt() 方法，给等待的线程发送中断信号，可以唤醒线程
* */

public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
            System.out.println(Thread.currentThread().getName() + ",park()之前中断标志：" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + ",park()之后中断标志：" + Thread.currentThread().isInterrupted());
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
        });
        t1.setName("t1");
        t1.start();
        //休眠5秒
        TimeUnit.SECONDS.sleep(5);
        t1.interrupt();

    }
}
