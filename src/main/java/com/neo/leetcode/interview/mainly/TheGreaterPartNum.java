package com.neo.leetcode.interview.mainly;

/*
 * @Description:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
   你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author Neo Lin
 * @Date  2020/2/24 18:53
 */
public class TheGreaterPartNum {


    public static void main(String[] args) {
        int[] nums = new int[]{1,5,6,5,5,2,5} ;
        Solution solution = new Solution();
        int i = solution.majorityElement(nums);
        System.out.println(i);
    }
    public static class Solution{
        public int majorityElement(int[] nums) {
            int count = 0;
            int flag=0;
            for(int num : nums){
                if(count == 0){
                    flag = num;
                    count++;
                    continue;
                }
                if(flag == num){
                    count++;
                }else{
                    count--;
                }
            }
            return flag;
        }
    }
}
