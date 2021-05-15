package com.neo.leetcode.daily.q347;

import java.util.*;

/**
 * 找到前k个频率高的数字 todo ...
 */
public class Solution {

    Map<Integer, Integer> frequentMap = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        //先用频率表统计频率?
        int length = nums.length;

        for (int num : nums) {
            frequentMap.merge(num, 1, Integer::sum);
        }
        //然后根据频率进行排序 构造小顶堆
        Set<Integer> keys = frequentMap.keySet();
        Iterator<Integer> iterator = keys.iterator();
        //k个结果
        //先塞k个进去
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (iterator.hasNext()) {
                result[i] = iterator.next();
            }
        }
        //构建一个小顶堆
        buildHeap(result);

        //然后遍历后续的值进行比较
        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if (frequentMap.get(next) > frequentMap.get(result[0])) {
                //替换 并重新堆化
                result[0] = next;
                heapify(result, 0, k);
            }
        }
        sort(result);
        reverse(result);
        return result;
    }

    private void sort(int[] nums) {
        int j = nums.length - 1;
        while (j > 0) {
            swap(nums, 0, j);
            heapify(nums, 0, j);
            j--;
        }
    }

    private void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


    private void heapify(int[] nums, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        //如果该节点有左子节点,且子节点的值比父节点小, 交换
        if (left < length && frequentMap.get(nums[left]) < frequentMap.get(nums[smallest])) {
            smallest = left;
        }

        //如果该节点有右子节点,且子节点的值比父节点小, 交换
        if (right < length && frequentMap.get(nums[right]) < frequentMap.get(nums[smallest])) {
            smallest = right;
        }

        //如果发生了换位
        if (smallest != i) {
            swap(nums, i, smallest);
            //对下层节点接着换位
            heapify(nums, smallest, length);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    /**
     * 构建小顶堆
     */
    private void buildHeap(int[] nums) {
        int length = nums.length;
        for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
            System.out.println(i);
            heapify(nums, i, length);
        }
    }
}
