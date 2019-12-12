package com.example.huan.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/12 0012 上午 11:38
 */
public class Demo4 {

    //账户原始余额
    static int accountMoney = 19;
    //用于对账户余额做原子操作
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(accountMoney, 0);

    /**
     * 模拟2个线程同时更新后台数据库，为用户充值
     */
    static void recharge() {
        for (int i = 0; i < 2; i++) {
            int stamp = money.getStamp();
            new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    Integer m = money.getReference();
                    if (m == accountMoney) {
                        if (money.compareAndSet(m, m + 20, stamp, stamp + 1)) {
                            System.out.println("当前时间戳：" + money.getStamp() + ",当前余额：" + m + "，小于20，充值20元成功，余额：" + money.getReference() + "元");
                        }
                    }
                    //休眠100ms
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 模拟用户消费
     */
    static void consume() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            Integer m = money.getReference();
            int stamp = money.getStamp();
            if (m > 20) {
                if (money.compareAndSet(m, m - 20, stamp, stamp + 1)) {
                    System.out.println("当前时间戳：" + money.getStamp() + ",当前余额：" + m + "，大于10，成功消费10元，余额：" + money.getReference() + "元");
                }
            }
            //休眠50ms
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        recharge();
        consume();
    }

}
