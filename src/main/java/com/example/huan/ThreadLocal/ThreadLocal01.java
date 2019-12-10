package com.example.huan.ThreadLocal;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/10 0010 下午 2:29
 */
public class ThreadLocal01 {

    static void print(String str){
        System.out.println(str+":"+localVariable.get());
        //localVariable.remove();
    }

    //创建ThreadLocal变量
    static ThreadLocal<String> localVariable= new ThreadLocal<>();

    public static void main(String[] args) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");

                print("threadOne");

                System.out.println("threadOne remove after" + ":" + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {

            @Override
            public void run() {
                localVariable.set("threadTwo local variable");

                print("threadTwo");

                System.out.println("threadTwo remove after" + ":" + localVariable.get());
            }
        });
        threadOne.start();
        threadTwo.start();

    }
    }