package com.neo.leetcode.interview.mainly;

/*
 * @Description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
                每行的元素从左到右升序排列。
                每列的元素从上到下升序排列。
 * @Author Neo Lin
 * @Date  2020/2/24 18:53
 */
public class SearchMatrix {


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] a = new int[7][];
        a[0] = new int[]{3,3,8,13,13,18};
        a[1] = new int[]{4,5,11,13,18,20};
        a[2] = new int[]{9,9,14,15,23,23};
        a[3] = new int[]{13,18,22,22,25,27};
        a[4] = new int[]{18,22,23,28,30,33};
        a[5] = new int[]{21,25,28,30,35,35};
        a[6] = new int[]{24,25,33,36,37,40};
//        a[0] = new int[]{1,4,7,11,15};
//        a[1] = new int[]{2,5,8,12,19};
//        a[2] = new int[]{3,6,9,16,22};
//        a[3] = new int[]{10,13,14,17,24};
//        a[4] = new int[]{18,21,23,26,30};
        boolean b = solution.searchMatrix(a, 21);
        System.out.println(b);
    }


    /*
     * @Description: 笨比办法 全部循环系列
     * @Author Neo Lin
     * @Date  2020/2/24 15:21
     */
    public static class Solution{
        public boolean searchMatrix(int[][] matrix, int target) {
            int columnFlag = 0;  //列标志
            for(int[] rows : matrix){


                for(int i=columnFlag;i<rows.length;i++){
                    System.out.println(columnFlag);
                    System.out.println("&&&&"+rows[i]);
                    if(rows[i] == target){
                        return true;
                    }
//                    if(rows[i]>target){//回退
//                        if(i>0) {
//                            columnFlag = i - 1;
//                        }
//                        break;
//                    }

                }
            }
            return false;
        }
    }

    public static class Solution2{
        public boolean searchMatrix(int[][] matrix, int target) {
            //选取方阵右上角为遍历起点
            int startRow = 0;
            int startColumn = matrix[0].length - 1;
            while(startRow < matrix.length && startColumn >= 0){
                System.out.println(matrix[startRow][startColumn]);
                if(matrix[startRow][startColumn] > target){
                    startColumn --;
                }else if(matrix[startRow][startColumn] < target){
                    startRow ++;
                }else{
                    return true;
                }
            }
            return false;
        }


    }
}
