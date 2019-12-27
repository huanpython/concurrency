package com.example.huan.dynamic;

/**
 * @Author huanfuan
 * @Date 2019/12/27 21:13
 * @Version 1.0
 */


/**
 * @author : huanfuan
 *         description: 一个类型变量的泛型类
 **/

public class genericClassTest<T> {

    private T mData;

    public genericClassTest() {
    }

    public T getmData() {
        return mData;
    }

    public void setmData(T mData) {
        this.mData = mData;
    }
}
