package com.practice.cache;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheLinkedHashSet {

    final int capacity;
    Set<Integer> cache;

    public LRUCacheLinkedHashSet(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashSet<>(capacity);
    }

    public boolean get(int key){
        if(!cache.contains(key)){
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void put(int key){
        if(cache.size() == capacity){
            Integer next = cache.iterator().next();
            cache.remove(next);
        }
        cache.add(key);
    }

    public void get_Value(int key){
        if(!get(key))
            put(key);
    }

    public void display(){
        LinkedList<Integer> list = new LinkedList<>(cache);
        Iterator<Integer> itr = list.descendingIterator();

        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashSet lru = new LRUCacheLinkedHashSet(3);

                                  /// recent ---> old    (capacity is 3)
        lru.get_Value(10);    /// 10
        lru.get_Value(1);     /// 1   10
        lru.get_Value(5);     /// 5    1   10
        lru.get_Value(1);     /// 1    5   10
        lru.get_Value(20);    /// 20   1    5

        lru.display();
    }
}
