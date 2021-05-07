package com.neo.leetcode.daily.q1720;

class Solution {

    /**
     * @param encoded 编码后的数组
     * @param first   原数组的第一个元素
     * @return
     */
    public int[] decode(int[] encoded, int first) {

        int[] decode = new int[encoded.length + 1];
        decode[0] = first;
        int temp = first;
        for (int i = 0; i < encoded.length; i++) {
            decode[i + 1] = encoded[i] ^ temp;
            temp = decode[i + 1];
        }
        return decode;

    }


}