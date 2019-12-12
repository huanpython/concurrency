package com.example.huan.LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 3:05
 */

//https://www.tuicool.com/articles/nUnMf23

/*
* t1中调用 LockSupport.park(); 让当前线程t1等待，
* 主线程休眠了5秒之后，调用 LockSupport.unpark(t1); 将t1线程唤醒，
* 输出结果中1、3行结果相差5秒左右，说明t1线程等待5秒之后，被唤醒了。

LockSupport.park(); 无参数，内部直接会让当前线程处于等待中；
* unpark方法传递了一个线程对象作为参数，表示将对应的线程唤醒。
* */

public class Demo7 {

    public static void main(String[] args) throws InterruptedException{
        Thread t1=new Thread(()->{
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " start!");
            LockSupport.park();
            System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + " 被唤醒!");
        });
        t1.setName("t1");
        t1.start();
        //休眠5秒
        TimeUnit.SECONDS.sleep(5);
        LockSupport.unpark(t1);
        System.out.println(System.currentTimeMillis() + ",LockSupport.unpark();执行完毕");
    }
}
