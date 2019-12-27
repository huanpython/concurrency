package com.example.huan.dynamic;

/**
 * @Author huanfuan
 * @Date 2019/12/27 21:23
 * @Version 1.0
 */
public class dynamic {


    public static <T> int indexof(T[] arr,T elm){
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals(elm)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        indexof(new Integer[]{1,3,5},10);
    }
}
