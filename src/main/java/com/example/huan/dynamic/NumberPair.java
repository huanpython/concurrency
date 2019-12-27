package com.example.huan.dynamic;

/**
 * @Author huanfuan
 * @Date 2019/12/27 21:27
 * @Version 1.0
 */
public class NumberPair<U extends Number,V extends Number>extends Pair1<U,V> {

    public NumberPair(U first, V second) {
        super(first, second);
    }

    public double sum(){
        return getFirst().doubleValue()+getSecond().doubleValue();
    }


    public static void main(String[] args) {
        NumberPair<Integer,Double>pair=new NumberPair<>(10,12.34);
        double sum=pair.sum();
    }
}
