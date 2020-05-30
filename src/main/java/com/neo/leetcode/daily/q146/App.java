package com.neo.leetcode.daily.q146;

public class App {

    public static void main(String[] args) {
        Solution.LruCache cache = new Solution.LruCache(2);
        cache.put(2,1);
        cache.put(2,2);
        int i = cache.get(2);
        System.out.println(i);



        cache.put(1,1);
        cache.put(4,1);
        i = cache.get(2);
        System.out.println(i);
    }
}
