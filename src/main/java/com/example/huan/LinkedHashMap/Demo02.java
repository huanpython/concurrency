package com.example.huan.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/17 0017 上午 10:56
 */
public class Demo02 {
    public static void main(String[] args) {
        Map<String,Integer> accessMap=new LinkedHashMap<>(16,  0.75f,true);
        accessMap.put("c",100);
        accessMap.put("d",200);
        accessMap.put("a",500);
        accessMap.get("c");
        accessMap.put("d",300);

        for (Map.Entry<String,Integer> entry:accessMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
