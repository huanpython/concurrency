package com.example.huan.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 3:32
 */
public class Atomic {

    private static AtomicLong atomicLong=new AtomicLong();

    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,5,6,0,56,0};
    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i=0;i<size;++i){
                    if (arrayOne[i].intValue() ==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        Thread threadTwo=new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (int i=0;i<size;++i){
                    if (arrayTwo[i].intValue() ==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.printf("count 0:" + atomicLong.get());


    }
}
