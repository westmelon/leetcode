package com.neo.sword2offer.q3;

public class App {

    public static void main(String[] args) {
//        int nums[] = new int[]{2,3,1,0,2,5,3};
        int nums[] = new int[]{3,2,1,4,6,7,5,8,9,0};
        Solution solution = new Solution();
        int repeat = solution.findRepeat(nums);
        System.out.println(repeat);

    }
}
