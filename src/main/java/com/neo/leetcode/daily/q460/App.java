package com.neo.leetcode.daily.q460;

public class App {


    public static void main(String[] args) {
        Solution.LFUCache cache = new Solution.LFUCache(2);

        System.out.println(cache.get(1));
        cache.put(2,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(3,1);
        cache.put(4,5);
        cache.put(6,7);
        System.out.println(cache.get(2));
        System.out.println(cache.get(4));
        System.out.println(cache.get(6));
    }

}
