package com.example.huan.CAS;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/10 0010 下午 3:04
 */
public class AtomicCounter {
    private AtomicInteger atomicInteger=new AtomicInteger();
    private int i =0;

    public static void main(String[] args) {
        final AtomicCounter counter=new AtomicCounter();
        List<Thread> ts =new ArrayList<>(100);
        long start = System.currentTimeMillis();
        for (int j =0; j<100; j++){
            Thread t = new Thread(()->{
                for (int i =0; i<10000;i++){
                    counter.count();
                    counter.safeCount();
                }
            });
            ts.add(t);
        }
        for (Thread t:ts){
            t.start();
        }
        //等待所有线程执行完成
        for (Thread t:ts){
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(counter.i);
        System.out.println(counter.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);

    }


    /**
     * 使用CAS 实现线程安全计数器
     */
    private void safeCount(){
        for (;;){
            int i =atomicInteger.get();
            boolean flag= atomicInteger.compareAndSet(i,++i);
            if (flag){break;}
        }
    }

    /**
     * 非线程安全计数器
     */
    private void count() {
        i++;
    }


}
