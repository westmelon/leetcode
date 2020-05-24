package com.neo.leetcode.daily.q37;

import java.util.Arrays;

/**
 * The type Solution.
 */
public class Solution {


    /**
     * 格子数
     */
    private int n = 3;  //
    /**
     * 总共的格子数
     */
    private int N = n * n;  //

    /**
     * 行中的数字
     */
    private int[][] rows = new int[N][N + 1];
    /**
     * 列中的数字
     */
    private int[][] columns = new int[N][N + 1];
    /**
     * 小格子中的数字
     */
    private int[][] box = new int[N][N + 1]; //小盒子的数字情况

    /**
     * 画板
     */
    private char[][] board;

    private boolean sudokuSolved = false;

    /**
     * Solve sudoku.
     *
     * @param board the board
     */
    public void solveSudoku(char[][] board) {
        //初始化数独格子
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int number = Character.getNumericValue(num);
                    placeNumber(i, j, number);
                }
            }
        }
        //从0，0开始回溯
        backtrace(0, 0);

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private int getSmallGridIndex(int row, int col) {
        return (row / n) * n + col / n;
    }

    /**
     * 回溯方法
     *
     * @param row the row
     * @param col the col
     */
    private void backtrace(int row, int col) {
        if (board[row][col] == '.') {
            //从1～9填充数据，如果无法达到要求则回溯
            for (int i = 1; i < 10; i++) {
                if (canPlace(row, col, i)) {
                    placeNumber(row, col, i);
                    placeNextNumber(row, col);
                    if (!sudokuSolved) {
                        //删除数字回溯
                        removeNumber(row, col, i);
                    }
                }
            }
        } else {
            placeNextNumber(row, col);
        }
    }

    /**
     * 校验填充的数字是否符合要求
     *
     * @param row the row
     * @param col the col
     * @param d   the d
     * @return the boolean
     */
    private boolean canPlace(int row, int col, int d) {
        int index = getSmallGridIndex(row, col);
        //所选数字在同一行、同一列、同一个小格子内未出现过
        return rows[row][d] + columns[col][d] + box[index][d] == 0;
    }


    /**
     * 摆放数字
     *
     * @param row the row
     * @param col the col
     * @param d   the d
     */
    private void placeNumber(int row, int col, int d) {
//        System.out.println(row + "-" + col + "-" + d);
        int index = getSmallGridIndex(row, col);
        rows[row][d]++;
        columns[col][d]++;
        box[index][d]++;
        board[row][col] = (char) (d + '0');
    }

    /**
     * 摆放下一个数字
     *
     * @param row the row
     * @param col the col
     */
    private void placeNextNumber(int row, int col) {
        //如果摆放到了最后一个格子 表示得出解
        if ((row == (N - 1)) && (col == (N - 1))) {
            sudokuSolved = true;
        } else {
            //处理换行
            if (col == (N - 1)) {
                backtrace(row + 1, 0);
            } else {
                backtrace(row, col + 1);
            }
        }
    }

    /**
     * 移除数字
     *
     * @param row 行数
     * @param col 列数
     * @param d   要移除的数字
     */
    private void removeNumber(int row, int col, int d) {
        int index = getSmallGridIndex(row, col);
        rows[row][d]--;
        columns[col][d]--;
        box[index][d]--;
        board[row][col] = '.';
    }
}
