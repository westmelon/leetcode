package com.neo.leetcode.q3;

import java.util.*;

public class Solution {
    //wrong
    public int lengthOfLongestSubstring(String s) {
        Set<Character> noRepeat = new HashSet<>();
        int max = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!noRepeat.contains(aChar)) {
                noRepeat.add(aChar);
            } else {
                max = noRepeat.size() > max ? noRepeat.size() : max;
                noRepeat = new HashSet<>();
                noRepeat.add(aChar);
            }
        }

        return noRepeat.size() > max ? noRepeat.size() : max;
    }

    //滑动窗口解决
    public int lengthOfLongestSubstringBySlideWindow(String s) {
        Set<Character> noRepeat = new HashSet<>();
        int start = 0;
        int end = 0;
        int length = s.length();
        int max = 0;
        while (start < length && end < length) {
            //end ++ 直到遇到重复的
            if(!noRepeat.contains(s.charAt(end))){
                noRepeat.add(s.charAt(end++));
                max = Math.max(max, end-start);
            }else{ //重复了
                noRepeat.remove(s.charAt(start++));
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringBySlideWindow2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {//从被重复的元素开始算窗口的起始值 遇到重复值以最后一个重复值算
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }

}
