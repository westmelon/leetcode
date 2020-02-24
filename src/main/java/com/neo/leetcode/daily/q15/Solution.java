package com.neo.leetcode.daily.q15;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 笨比办法(去重贼吉尔麻烦)
 * @Author Neo Lin
 * @param
 * @return
 * @Date  2020/2/22
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();
        int length = nums.length;
        int head = 0;
        int tail = length - 1;
        int middle;
        while (head < length - 2) {
            tail = length - 1;
            while (tail - head > 0) {
                middle = head + 1;
                while (middle < tail) {
                    if (nums[head] + nums[middle] + nums[tail] == 0) {
                        List<Integer> detail = new ArrayList<>();
                        detail.add(nums[head]);
                        detail.add(nums[middle]);
                        detail.add(nums[tail]);
                        rtn.add(detail);
                        break;
                    }
                    middle++;
                }
                tail--;
            }
            head++;
        }
        return rtn;
    }
}
