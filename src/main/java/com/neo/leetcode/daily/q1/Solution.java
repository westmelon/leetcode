package com.neo.leetcode.daily.q1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        int[] rtn = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (maps.size() > 0) {
                Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
                for (Map.Entry<Integer, Integer> entry : entries) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    if(temp == value){
                        rtn[0] = key;
                        rtn[1]= i;
                    }
                }
            }
            maps.put(i, nums[i]);  //将索引和值存入map
        }
        return rtn;
    }

}
