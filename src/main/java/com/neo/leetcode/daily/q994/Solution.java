package com.neo.leetcode.daily.q994;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {

        int[] genRow = {0, -1, 0, 1};
        int[] genCol = {-1, 0, 1, 0};

        //列数
        int colLength = grid[0].length;
        //行数
        int rowLength = grid.length;

        Queue<Integer> queue = new ArrayDeque<>();
        //记录节点深度
        Map<Integer, Integer> depth = new HashMap<>(16);
        //首先将所有的烂橘子入队
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                //烂橘子
                if (grid[r][c] == 2) {
                    Integer code = r * colLength + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int answer = 0;

        //广度优先遍历所有节点
        while (!queue.isEmpty()) {
            Integer current = queue.remove();
            int row = current / colLength;
            int col = current % colLength;
            //依次对四个方向上的橘子遍历
            for (int direction = 0; direction < 4; direction++) {
                int afterRow = row + genRow[direction];
                int afterCol = col + genCol[direction];
                if(afterRow >=0 && afterRow < rowLength && afterCol >=0 && afterCol<colLength
                        && grid[afterRow][afterCol] == 1){
                    grid[afterRow][afterCol] = 2; //橘子懒了
                    int code = afterRow * colLength + afterCol;
                    answer = depth.get(current) + 1;
                    depth.put(code, answer);
                    queue.add(code);
                }
            }
        }

        //最后遍历一次有没有好的橘子
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (grid[r][c] == 1) { //烂橘子
                    return -1;
                }
            }
        }

        return answer;

    }
}
