package com.neo.leetcode.daily.q7;

public class Solution2 {


    public int reverse(int x){
        int result = 0;
        int pop;
        while(x!=0) {
            pop = x % 10;
            if(result > Integer.MAX_VALUE /10 || (result == Integer.MAX_VALUE /10 && pop > Integer.MAX_VALUE % 10)){
                result = 0;
                break;
            }else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)){
                result = 0;
                break;
            }
            result = result * 10 + pop;
            x = x / 10;
        }
        return result;
    }
}
