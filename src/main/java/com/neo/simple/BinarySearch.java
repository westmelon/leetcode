package com.neo.simple;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 9, 11, 23, 123};
//        int search = search(nums, 23);
//        System.out.println(search);
//        System.out.println(nums[search]);

        Thread a = new Thread(()->{
            while(true){
                System.out.println(666);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.start();
    }

    public static int search(int[] nums, int target) {

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (int) Math.floor((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
