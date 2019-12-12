package com.example.huan.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 下午 3:11
 */

/*
* 方式1：Object中的wait、notify、notifyAll方法
  方式2：juc中Condition接口提供的await、signal、signalAll方法
  方式3：juc中的LockSupport提供的park、unpark方法
* */

public class Demo10 {

    static class BlockerDemo {
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
        });
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            LockSupport.park(new BlockerDemo());
        });
        t2.setName("t2");
        t2.start();
    }
}
