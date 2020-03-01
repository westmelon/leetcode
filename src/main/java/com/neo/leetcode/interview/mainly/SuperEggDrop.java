package com.neo.leetcode.interview.mainly;

/*
 * @Description:
 * @Author Neo Lin
 * @Date  2020/2/24 18:55
 */
public class SuperEggDrop {
    /*你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
    每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
    你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
    每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
    你的目标是确切地知道 F 的值是多少。
    无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？（最坏情况）*/

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.superEggDrop(1, 2);
        System.out.println(i);
    }

    public static class Solution{ //如果有大于一个鸡蛋 优先使用二分查找 否则使用保守的办法
        /*
         * @Description:
         * @Author Neo Lin
         * @param  [K 鸡蛋数量, N楼层高度]
         * @return  int
         * @Date  2020/2/29
         */
        public int superEggDrop(int K, int N) {

            //首先确定该楼层需要二分的次数？ N开方向下取证

            int min =(int) (Math.log(N)/Math.log(2)); //最小次数

            if(K < min){
                int v = (int) (N / Math.pow(2, min - K));
                min = K + v;
            }

            //如果K不足以支撑次数
            return min;
        }

    }
}
