package com.example.huan.LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 3:08
 */
/*
* 唤醒方法在等待方法之前执行，线程也能够被唤醒，这点是另外2中方法无法做到的。
* Object和Condition中的唤醒必须在等待之后调用，线程才能被唤醒。
* 而LockSupport中，唤醒的方法不管是在等待之前还是在等待之后调用，线程都能够被唤醒
* */

public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
            LockSupport.park();
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
        });
        t1.setName("t1");
        t1.start();
        //休眠1秒
        TimeUnit.SECONDS.sleep(1);
        LockSupport.unpark(t1);
        System.out.println(System.currentTimeMillis() + ",LockSupport.unpark();执行完毕");
    }
}
