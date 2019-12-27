package com.example.huan.dynamic;

/**
 * @Author huanfuan
 * @Date 2019/12/27 21:21
 * @Version 1.0
 */
public class Pair1<U,V> {
    U first;

    V second;

    public Pair1(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
