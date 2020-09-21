package com.neo.leetcode.daily.q5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    /*
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * */
    public String longestPalindrome(String s) {
        String answer = "";

//        char[] chars = new char[s.length() / 2];
        LinkedList<Character> characters = new LinkedList<>();
        boolean isEqual = false;
        //回溯？
        for (int i = 0; i < s.length(); i++) {
            //查找一半？
            char c = s.charAt(i);
            characters.add(c);

            //开始判断是否存在回文序列
            if(characters.getLast().equals(s.charAt(i+1))){
                //当前字符与下一个字符相等
            }else if(characters.getLast().equals(s.charAt(i+2))){
                //当前字符与下下个字符相等
            }else{
                //不构成回文序列

            }

        }


        return "";
    }



    //中心扩散法


}
