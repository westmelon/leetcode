package com.neo.sword2offer.q7;

import com.neo.struct.BinaryTreeNode;

import java.util.Arrays;

public class Solution {

    /**
     * 已知先序遍历先访问根节点  中序遍历先访问左子树再访问根节点再访问右子树,故可拆解成子问题去解决
     *
     * @param pre 先序
     * @param in  中序
     * @return
     */
    public BinaryTreeNode rebuildTree(int[] pre, int[] in) {

        return rebuild(pre, in);
    }

    public BinaryTreeNode rebuild(int[] pre, int[] in) {
        System.out.println("pre" + Arrays.toString(pre));
        System.out.println("in" + Arrays.toString(in));
        //序列为空, 没有子树
        if (pre.length == 0  || in.length == 0) {
            return null;
        }
        int rootValue = pre[0];
        int index = 0;
        //找到根节点在中序序列中的下标
        for (int i = 0; i < in.length; i++) {
            if (rootValue == in[i]) {
                index = i;
                break;
            }
        }
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        if(index == 0 && in.length == 1){
            return root;
        }
        //index代表了左子树的个数 in.length - index -1 代表右子树的个数
        int length = in.length;
        int leftCount = index;

        int[] leftPre = Arrays.stream(pre, 1, leftCount + 1).toArray();
        int[] rightPre = Arrays.stream(pre, leftCount + 1, length).toArray();
        int[] leftIn = Arrays.stream(in, 0, leftCount).toArray();
        int[] rightIn = Arrays.stream(in, leftCount + 1, length).toArray();
        root.left = rebuild(leftPre, leftIn);
        root.right = rebuild(rightPre, rightIn);
        return root;
    }
}
