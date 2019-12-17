package com.example.huan.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/17 0017 上午 11:14
 */
public class Demo01 {
    public static void main(String[] args) {
        Set<String> set=new LinkedHashSet<>();
        set.add("b");
        set.add("c");
        set.add("a");
        set.add("c");
        System.out.println(set);
    }
}
