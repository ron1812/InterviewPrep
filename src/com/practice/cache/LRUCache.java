package com.practice.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int size;

    private LRUCache(int size){
        super(size,0.75f,true);
        this.size = size;
    }

    //If hashmap size increases that the size we have specified then delete the eldest entry
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > size;
    }

    public static <K,V> LRUCache<K,V> getLRUCacheInstance(int size){
        return new LRUCache<K,V>(size);
    }

    // The least recently used data should be removed
    // Keep the size of the cache as 3
    public static void main(String[] args) {

        LRUCache<Object, Object> lruCacheInstance = LRUCache.getLRUCacheInstance(3);

        lruCacheInstance.put("ROHAN","DSOUZA");
        lruCacheInstance.put("JESSY","DSOUZA");
        lruCacheInstance.put("SHAILA","DSOUZA");
        lruCacheInstance.put("PRITISH","KUMAR");

        System.out.println("Cache size is "+lruCacheInstance.size);

        System.out.println("################### CACHE ENTRY ######################");
        lruCacheInstance.entrySet().forEach(System.out::println);

        lruCacheInstance.get("JESSY");

        System.out.println("################### CACHE ENTRY AFTER ACCESSING JESSY KEY ######################");

        lruCacheInstance.entrySet().forEach(System.out::println);

        lruCacheInstance.put("TEST","CACHE");

        System.out.println("################### CACHE ENTRY AFTER NEW ENTRY ######################");

        lruCacheInstance.entrySet().forEach(System.out::println);
    }
}
