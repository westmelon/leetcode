package com.neo.simple;

import java.util.Arrays;

/**
 * 找到前k个大的数
 */
public class TopK {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,43,35,234,23,434,35351,13424,31232,1212,123};
        TopK topK = new TopK();
        int[] ints = topK.topK(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topK(int[] nums, int k) {
        //构建一个大小为k的小顶堆

        int[] heapArray = Arrays.copyOf(nums, k);
        smallHeap(heapArray);

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heapArray[0]) {
                heapArray[0] = nums[i];
                heapify(heapArray, 0, heapArray.length);
            }
        }
        //
        int[] sort = sort(heapArray);
        reverse(sort);
        return sort;
    }

    private int[] sort(int[] nums) {
        int[] rtn = Arrays.copyOf(nums, nums.length);
        int j = rtn.length - 1;
        while (j > 0) {
            swap(rtn, 0, j);
            heapify(rtn, 0, j);
            j--;
        }
        return rtn;
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

    private void smallHeap(int[] nums) {
        int length = nums.length;
        for (int i = (int) Math.floor(length / 2); i > 0; i--) {
            heapify(nums, i, length);
        }
    }

    //堆化
    private void heapify(int[] nums, int i, int length) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < length && nums[left] < nums[smallest]) {
            smallest = left;
        }
        if (right < length && nums[right] < nums[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(nums, i, smallest);
            heapify(nums, smallest, length);
        }

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
