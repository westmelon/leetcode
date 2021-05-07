package com.neo.sword2offer.q3;

public class Solution {

    /**
     * 方法1. 排序后遍历,找出重复的元素
     * 方法2. 借助hashset
     * 方法3. 组内替换元素,与下标不相等的为重复元素
     */
    public int findRepeat(int[] nums){
        if(nums == null){
            return -1;
        }
        for(int i = 0; i< nums.length; i++){
            while( nums[i] != i){
                int index = nums[i];
                if(nums[i] == nums[index]){
                    return index;
                }
                //swap
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return -1;
    }
}
