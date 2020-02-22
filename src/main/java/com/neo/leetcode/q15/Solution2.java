package com.neo.leetcode.q15;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 稍微聪明一点的办法
 * @Author Neo Lin
 * @param
 * @return
 * @Date  2020/2/22
 */
public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();
        List<List<Integer>> rtn = new ArrayList<>();
        //先排序
        popSort(nums);
        int length = nums.length;
        int head = 0;
        int tail = length - 1;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0 )
                break;
            if(i>0 && nums[i] ==nums[i-1]){
                continue;
            }
            head = i + 1;
            tail = length - 1;
            while (head < tail) {
                if (nums[i] + nums[head] + nums[tail] > 0) {
                    tail--;
                } else if (nums[i] + nums[head] + nums[tail] < 0) {
                    head++;
                } else {  //相等的情况
                    while(head <tail && nums[head] == nums[head+1]){
                        head ++;
                    }
                    while(head <tail && nums[tail] == nums[tail-1]){
                        tail --;
                    }
                    List<Integer> detail = new ArrayList<>();
                    rtn.add(detail);
                    detail.add(nums[i]);
                    detail.add(nums[head]);
                    detail.add(nums[tail]);
                    head ++;
                    tail --;
                }
            }
        }
        return rtn;
    }

    private void popSort(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

}
