package com.neo.leetcode.daily.q994;

public class App {

    public static void main(String[] args) {
        int[][] grid = new int[4][];
        grid[0] = new int[]{1};
        grid[1] = new int[]{2};
        grid[2] = new int[]{1};
        grid[3] = new int[]{1};
        Solution solution = new Solution();
        int i = solution.orangesRotting(grid);
        System.out.println(i);
    }
}
