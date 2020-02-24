package com.neo.leetcode.interview.mainly;


/*
 * @Description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @Author Neo Lin
 * @Date  2020/2/24 16:05
 */
public class MergeArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
//        Solution solution = new Solution();
        Solution3 solution = new Solution3();
        solution.merge(nums1, 0, nums2, 1);
        System.out.println(1);
    }

    /*
     * @Description: 笨比办法 合并后排序
     * @Author Neo Lin
     * @Date  2020/2/24 16:36
     */
    public static class Solution {
        //将数组2拼接到数组1尾部 从数组2的部分开始冒泡
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            int temp;
            for (int i = m; i < m + n; i++) {
                for (int j = i; j > 0; j--) {
                    if (nums1[j] < nums1[j - 1]) {
                        temp = nums1[j - 1];
                        nums1[j - 1] = nums1[j];
                        nums1[j] = temp;
                    }
                }
            }
        }
    }

    public static class Solution2 {
        //双指针从前往后
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] copy_nums1 = new int[m];
            System.arraycopy(nums1, 0, copy_nums1, 0, m);

            int p1 = 0;
            int p2 = 0;
            int p = 0;
            while ((p1 < m) && (p2 < n)) {
                nums1[p++] = copy_nums1[p1] < nums2[p2] ? copy_nums1[p1++] : nums2[p2++];
            }
            //
            if (p1 < m) {
                System.arraycopy(copy_nums1, p1, nums1, p1 + p2, m - p1);
            }
            if (p2 < n) {
                System.arraycopy(nums2, p2, nums1, p1 + p2, n - p2);
            }
        }
    }

    public static class Solution3 {
        //双指针从后往前
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p = m + n - 1;
            int p1 = m - 1;
            int p2 = n - 1;
            while ((p1 >= 0) && (p2 >= 0)) {
                nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}
