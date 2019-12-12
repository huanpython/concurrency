package com.example.huan.atomic;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 上午 11:26
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 跟着阿里p7学并发，微信公众号：javacode2018
 */

/*  使用AtomicInteger实现网站访问量计数器功能，
    模拟100人同时访问网站，每个人访问10次
* */

public class Demo1 {
    //访问次数
    static AtomicInteger count = new AtomicInteger();

    //模拟访问一次
    public static void request() throws InterruptedException {
        //模拟耗时5毫秒
        TimeUnit.MILLISECONDS.sleep(5);
        //对count原子+1
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();
        int threadSize=100;
        CountDownLatch countDownLatch=new CountDownLatch(threadSize);
        for (int i=0;i<threadSize;i++){
            Thread thread=new Thread(()->{
                try {
                    for (int j = 0; j < 10; j++){
                        request();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "，耗时：" + (endTime - startTime) + ",count=" + count);
    }

}
