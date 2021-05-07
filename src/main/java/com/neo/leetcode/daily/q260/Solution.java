package com.neo.leetcode.daily.q260;

public class Solution {

    /**
     * 输入: [1,2,1,3,2,5]
     * 输出: [3,5]
     */
    public int[] singleNumber(int[] nums) {
        //找出只出现一次的两个数字，无关顺序
        //1.所有数字异或,结果为那两个数字的异或值
        int xor = 0;
        int xor1 = 0;
        int xor2 = 0;
        for(int num : nums){
            xor ^= num;
        }
        //2.找出最低位为1的比特位
        int bitmask = xor & -xor;
        for(int num : nums){
            if((num & bitmask) != 0){
                xor1 ^= num;
            }
        }
        xor2 = xor ^ xor1;
        return new int[]{xor1, xor2};
    }
}
