package com.neo.leetcode.daily.q645;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //TODO 260 136 137 相关联

    public int[] findErrorNums(int[] nums) {
        //1.计算正确的合计值
        //2.计算非正确的合计值
        //3.找到重复的那个元素

        int length = nums.length;
        int start = 1;
        int end = length;
        int right = (1 + length) * length / 2;
        int[] result = new int[2];
        //数字是否出现
        Map<Integer, Boolean> map = new HashMap<>();
        int wrong = 0;
        int repeat = 0;
        int lost;
        for (int i = 0; i < length; i++) {
            Boolean isRepeat = map.getOrDefault(nums[i], Boolean.FALSE);
            if (isRepeat) {
                repeat = nums[i];
            } else {
                map.put(nums[i], Boolean.TRUE);
            }
            //累加
            wrong = wrong + nums[i];
        }
        if (repeat != 0) {
            lost = repeat + right - wrong;
            result[0] = repeat;
            result[1] = lost;
            return result;
        }

        return null;
    }


    /**
     * 解法2 使用异或
     * 1.两个相同的数字异或的结果为0
     * 2.x & -x 的结果为最低位为1的比特位代表的二进制值
     * 3.如果 a ^ b = c 我们这时候，只要知道c对应的二进制数中某一个位为1的位数N，比如十进制7二进制表示形式为111，
     * 那么可取N=1/2/3，然后将c与数组中第N位为1的数挨个进行异或，异或结果就是a，b中一个，然后用c异或其中一个数，就可以求出另外一个数了。
     *
     */
    public int[] findErrorNums2(int[] nums) {
        //xor = x^y 其中一个为缺失的一个为重复的
        //此时的值为x^y
        int xor = 0;
        int xor0 = 0;
        int xor1 = 0;
        //将期望的数组和实际的数组全部异或 最后得到的为缺失数和重复数的异或值
        for (int i = 1; i <= nums.length; i++) {
            xor ^= (i ^ nums[i-1]);
        }
        //求最低比特位 最右边位1的位置
        int bitmask = xor & -xor;
        //结合第三点求出其中一个数
        for (int i = 1; i <= nums.length; i++) {
            if ((i & bitmask) != 0) {
                xor1 ^= i;
            }
            if ((nums[i-1] & bitmask) != 0) {
                xor1 ^= nums[i-1];
            }
        }
        //求出另一个数
        xor0 = xor ^ xor1;
        //判断谁是重复的数,谁是缺的数
        for (int num : nums) {
            if ((num ^ xor0) == 0) {
                return new int[]{xor0, xor1};
            }
        }
        return new int[]{xor1,xor0};
    }
}
