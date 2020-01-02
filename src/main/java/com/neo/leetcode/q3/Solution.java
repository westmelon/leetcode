package com.neo.leetcode.q3;

import java.util.HashSet;
import java.util.Set;

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
}
