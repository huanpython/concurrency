package com.example.huan.ReentrantLock;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 4:13
 */
public class Demo2 {


    private static int num = 0;

    private static synchronized void add() {
        num++;
    }

    public static class T extends Thread{

        @Override
        public void run() {
            for (int i=0;i<10000;i++){
                Demo2.add();
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

        System.out.println(Demo2.num);
    }
}
