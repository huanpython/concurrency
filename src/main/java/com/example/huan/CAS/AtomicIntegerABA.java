package com.example.huan.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
* https://www.cnblogs.com/9dragon/p/12023971.html?utm_source=tuicool&utm_medium=referral
* */


/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 上午 10:51
 */
public class AtomicIntegerABA {

    private static AtomicInteger atomicInteger = new AtomicInteger(100);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //线程1
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get());
            atomicInteger.compareAndSet(100, 50);
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get());
        });

        //线程2
        executorService.execute(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get());
            atomicInteger.compareAndSet(50, 100);
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get());
        });

        //线程3
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get());
            atomicInteger.compareAndSet(100, 50);
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get());
        });

        executorService.shutdown();
    }
    }

