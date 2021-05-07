package com.neo.sword2offer.q7;

import com.neo.struct.BinaryTreeNode;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        Solution solution = new Solution();
        BinaryTreeNode binaryTreeNode = solution.rebuildTree(pre, in);

        System.out.println(1);
    }
}
