package com.example.huan.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/13 0013 上午 10:40
 */

/*
* 迭代器封装了各种数据组织方式的迭代操作，提供了简单和一致的接口
* */

public class Demo01 {

    public static void main(String[] args) {
        ArrayList<Integer>intList=new ArrayList<Integer>();
        intList.add(123);
        intList.add(456);
        intList.add(789);
        for (Integer a:intList){
            System.out.println(a);
        }

        System.out.printf("---------------");

        Iterator<Integer> it=intList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
