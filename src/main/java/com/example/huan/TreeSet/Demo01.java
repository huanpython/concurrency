package com.example.huan.TreeSet;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/17 0017 上午 10:41
 */
public class Demo01 {

    public static void main(String[] args) {
        Set<String> words=new TreeSet<String>();
        words.addAll(Arrays.asList(new String[]{
                "tree","map","hash","map",
        }));
        for (String w:words){
            System.out.print(w+" ");
        }
    }
}
