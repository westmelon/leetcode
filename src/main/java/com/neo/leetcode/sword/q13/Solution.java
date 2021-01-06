package com.neo.leetcode.sword.q13;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     *
     * @param m 行
     * @param n 列
     * @param k 行列加起来不能超过的最大值
     * @return
     */
    public int movingCount(int m, int n, int k) {
        //构造行列之和的数组
        int[][] temp = new int[m][n];
        int[][] record = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                temp[row][col] = sumAll(row, col);
                record[row][col] = -1;
            }
        }
        int result = 0;
        for (int row = 0; row < m; row++) {
            if(temp[row][0] > k){
                break;
            }
            search(temp, record, row, 0, k);
        }
//        toString(temp);
        System.out.println("------");
//        toString(record);
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(record[i]));
        }
        //然后向下或者向右搜索
        //终止条件 1数组越界 2超过k 3该节点已访问?

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(record[row][col] == 1){
                    result ++;
                }
            }
        }
        return result;
    }

    private void toString(int[][] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            List<String> aa = new ArrayList<>();
            for (int j = 0; j < arrays[i].length; j++) {
                String a = String.valueOf(arrays[i][j]);
                if (arrays[i][j] < 10) {
                    a = "gg";
                }
                aa.add(a);
            }
            System.out.println(String.join(", ", aa));
        }
    }

    //优先遍历行内数据
    private void search(int[][] temp, int[][] record, int row, int col, int k) {
        //数组越界 直接返回
        if (row > temp.length - 1 || col > temp[0].length - 1) {
            return;
        } else if (temp[row][col] > k) {//不可达
            return;
        } else if (record[row][col] != -1) {
            //该节点已访问
            return;
        }
        //返回搜索到的个数
        else {
            int tempCol = col + 1;
            int tempRow = row + 1;
            search(temp, record, row, tempCol, k);
            //可以向下走,
            search(temp, record, tempRow, col, k);
            //返回前标记节点已访问 只记录行总数
            record[row][col] = 1;
        }
    }

    private int sumAll(int row, int col) {
        int i = sum(row) + sum(col);
        return i;
    }

    private int sum(int num) {
        int single = num % 10;
        int ten = num / 10;
        return single + ten;
    }


}
