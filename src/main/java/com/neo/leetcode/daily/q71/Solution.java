package com.neo.leetcode.daily.q71;

import java.util.LinkedList;

public class Solution {

    //笨比办法
    public String simplifyPath(String path) {
        path = path + "/";
        String[] split = path.split("");
        String gangjing = "/";
        String dd = "..";
        String d = ".";
        boolean hasGang = false;
        StringBuilder sb = new StringBuilder();
        LinkedList<String> dirs = new LinkedList<>();
        for (String ch : split) {
            if (!ch.equals(gangjing)) {
                sb.append(ch);
                hasGang = false;
            } else if (!hasGang) {
                String s = sb.toString();
                if (dd.equals(s) && dirs.size() > 0) {
                    dirs.removeLast();
                } else if (!dd.equals(s) && !d.equals(s) && !"".equals(s)) {
                    dirs.add(s);
                }
                sb = new StringBuilder();
                hasGang = true;
            }
        }
        String result = String.join(gangjing, dirs);
        result = gangjing + result;
        return result;
    }

}
