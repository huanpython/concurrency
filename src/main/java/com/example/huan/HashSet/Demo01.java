package com.example.huan.HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/13 0013 下午 4:57
 */
public class Demo01 {
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.addAll(Arrays.asList(new String[]{"hello","老马"}));
        for (String s:set){
            System.out.print(s + " ");
        }
    }
}
