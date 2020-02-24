package com.neo.leetcode.daily.q7;

import com.neo.leetcode.daily.q4.NeoStack;

/*
 * @Description: 笨比办法
 * @Author Neo Lin
 * @Date  2020/2/19 22:24
 */
public class Solution {

    public int reverse(int x) {
        int base;
        if(x < 0){
            base = -1;
        }else{
            base = 1;
        }
        x = Math.abs(x);
        NeoStack<Integer> integerNeoStack = number2Stack(x);
        return stack2Number(integerNeoStack, base);
    }

    public NeoStack<Integer> number2Stack(int num) {



        NeoStack<Integer> stack = new NeoStack<>(20);
        while(num > 0){
            int ssr = num % 10;
            stack.push(ssr);
//            bit += 1;
            num = (num - ssr )/10;
        }
        return stack;
    }

    public int stack2Number(NeoStack<Integer> stack, int base){
        int result = 0;
        int bit = 0;
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            //TODO 判断溢出
            if(base == 1 &&( result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))){
                result = 0;
                break;
            }else if(base == -1 &&( result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))){
                result = 0;
                break;
            }
            result += base * pop * Math.pow(10, bit);
            bit += 1;
        }

        return result;
    }
}
