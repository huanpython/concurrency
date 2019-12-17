package com.example.huan.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/17 0017 上午 10:49
 */
public class Demo01 {
    public static void main(String[] args) {
        Map<String,Integer>seqMap=new LinkedHashMap<>();
        seqMap.put("c",100);
        seqMap.put("d",200);
        seqMap.put("a",500);
        seqMap.put("d",300);
        for (Map.Entry<String,Integer> entry:seqMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
