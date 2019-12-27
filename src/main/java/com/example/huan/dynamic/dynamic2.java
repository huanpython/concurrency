package com.example.huan.dynamic;

/**
 * @Author huanfuan
 * @Date 2019/12/27 21:42
 * @Version 1.0
 */
public class dynamic2 {

    public static <T extends Comparable> T max(T[] arr){
        T max = arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i].compareTo(max)>0){
                max=arr[i];
            }
        }
        return max;
    }

}
