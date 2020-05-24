package com.neo.leetcode.daily.q210;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] aa = new int[4][];
        aa[0] = new int[]{1,0};
        aa[1] = new int[]{2,0};
        aa[2] = new int[]{3,1};
        aa[3] = new int[]{3,2};
        int[] order = solution.findOrder(4, aa);
        String s = Arrays.toString(order);
        System.out.println(s);


    }
}
