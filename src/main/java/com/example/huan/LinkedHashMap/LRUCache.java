package com.example.huan.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huanfuan
 * @version 1.0
 * @date 2019/12/17 0017 上午 11:03
 */
public class LRUCache<K,V>extends LinkedHashMap<K,V> {
    private int maxEntries;

    public LRUCache(int maxEntries){
        super(16,0.75f,true);
        this.maxEntries=maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>maxEntries;
    }


    public static void main(String[] args) {
        LRUCache<String,Object> cache=new LRUCache<>(3);
        cache.put("a","abstract");
        cache.put("b","basic");
        cache.put("c","call");
        cache.get("a");
        cache.put("d","call");
        System.out.println(cache);
    }
}
