package com.example.huan.EnumMap;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;



/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/17 0017 上午 11:31
 */
public class Demo01 {


    public static Map<Size,Integer> countBySize(List<Clothes> clothes){
        Map<Size,Integer> map=new EnumMap<>(Size.class);
        for (Clothes c:clothes){
            Size size=c.getSize();
            Integer count=map.get(size);
            if (count!=null){
                map.put(size,count+1);
            }else {
                map.put(size,1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        List<Clothes> clothes= Arrays.asList(new Clothes[]{
                new Clothes("C001",Size.SMALL),new Clothes("C002",Size.LARGE),
                new Clothes("C003",Size.LARGE),new Clothes("C004",Size.MEDIUM),
                new Clothes("C005",Size.SMALL),new Clothes("C006",Size.SMALL),
        });
        System.out.println(countBySize(clothes));
    }
}
