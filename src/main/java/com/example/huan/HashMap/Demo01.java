package com.example.huan.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/13 0013 下午 3:25
 */
public class Demo01 {
    public static void main(String[] args) {
        Random rnd=new Random();
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i=0;i<1000;i++){
            int num=rnd.nextInt(4);
            Integer count=countMap.get(num);
            if (count==null){
                countMap.put(num,1);
            }else {
                countMap.put(num,count+1);
            }
        }
        for (Map.Entry<Integer,Integer>kv :countMap.entrySet()){
            System.out.println(kv.getKey()+","+kv.getValue());
        }
    }
}
