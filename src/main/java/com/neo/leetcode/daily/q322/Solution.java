package com.neo.leetcode.daily.q322;

public class Solution {

    //求能组成金额的最少硬币数量
    public int coinChange(int[] coins, int amount) {
        //自顶而下的动态规划法，求所有子问题的最优解  最后合并成问题的最优解
        if(amount<1)
            return 0;
        return coinChange(coins, amount, new int[amount]);
    }


    /*
     * @Description:
     * @Author Neo Lin
     * @param  [coins 金币的数组, remain 剩余的金额, count 子问题的最优解]
     * @return  int
     * @Date  2020/3/10
     */
    private int coinChange(int[] coins, int remain, int[] count) {

        if (remain < 0)  //没有搜索到最优解
            return -1;
        if (remain == 0) //没有余额则不用计算
            return 0;
        if (count[remain - 1] != 0) //该最优解已经计算过 直接返回
            return count[remain - 1];

        int min = Integer.MAX_VALUE;
        //
        for (int coin : coins) {
            int answer = coinChange(coins, remain - coin, count);
            if (answer >= 0 && answer < min) {

                min = answer + 1;
                System.out.println(String.format("当前余额%s,面值%s,最小硬币数%s",remain,coin,min));
            }

        }

        //给最优解的记录赋值
        count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remain - 1];
    }
}
