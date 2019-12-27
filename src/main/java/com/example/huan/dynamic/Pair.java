package com.example.huan.dynamic;

/**
 * @Author huanfuan
 * @Date 2019/12/27 21:20
 * @Version 1.0
 */
public class Pair<T> {

    T first;

    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
