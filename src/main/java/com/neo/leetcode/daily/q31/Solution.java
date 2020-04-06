package com.neo.leetcode.daily.q31;

import java.util.Arrays;

public class Solution {

    public void nextPermutation(int[] nums) {

        /* 从后往前查找数组 如果是按照升序排列 则没有比他更小的数
            如果碰到一个 变小了的数 那么将该数 与已经扫描过得数组中唯一一个比他大的数字替换
            并将扫描过得数组反转
                kkk*/
        int maxIndex = nums.length - 1;
        for (int i = maxIndex; i > 0; i--) {
            //碰到前一个数比他小的 需要交换反转
            if (nums[i - 1] < nums[i]) {

                for (int j = maxIndex; j > i - 1; j--) {
                    if (nums[i - 1] < nums[j]) {
                        //刚好比他大 交换num[i-1] 和 nums[j]
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                //反转i-1之后的数组 获得一个最小的数
                reverse(nums, i, maxIndex);
                break;
            }
            //如果遍历完都没有找到， 反转全部数据
            if (i == 1) {
                reverse(nums, 0, maxIndex);
            }
        }
        String s = Arrays.toString(nums);
        System.out.println(s);
    }

    //反转数组
    private void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }

    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
