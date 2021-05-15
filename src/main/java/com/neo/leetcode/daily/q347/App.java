package com.neo.leetcode.daily.q347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,2,2,3};
//        int[] a = new int[]{1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6,6};
        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(a, 2);
        System.out.println(Arrays.toString(ints));
    }
}
