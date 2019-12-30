package com.neo.leetcode.q1;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,5,7,9,12,24,235};
        int target = 247;
        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
