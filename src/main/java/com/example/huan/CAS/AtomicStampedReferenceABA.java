package com.example.huan.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 上午 10:53
 */
public class AtomicStampedReferenceABA {

    /**
     * 初始化账户中有100块钱，版本号对应0
     */
    private static AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(100, 0);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int[] result = new int[1];
//线程1
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get(result));
            //将100更新为50，版本号+1
            atomicInteger.compareAndSet(100, 50, 0, 1);
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get(result));
        });

        //线程2
        executorService.execute(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get(result));
            //将50更新为100，版本号+1
            atomicInteger.compareAndSet(50, 100, 1, 2);
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get(result));
        });

        //线程3
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get(result));
            //此线程还是以为没有其他线程进行过更改，所以旧版本号还是0
            atomicInteger.compareAndSet(100, 50, 0, 1);
            System.out.println(Thread.currentThread().getName() + " - " + atomicInteger.get(result));
        });
        executorService.shutdown();
    }


}
