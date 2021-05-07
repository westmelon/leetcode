package com.neo.simple;

public class MirrorTree {

    public boolean isMirror(BTreeNode node) {


        BTreeNode left = node.left;
        BTreeNode right = node.right;

        return rua(new BTreeNode[]{left}, new BTreeNode[]{right});


    }

    public boolean rua(BTreeNode[] left, BTreeNode[] right) {

        BTreeNode[] subL = new BTreeNode[2 * left.length];
        BTreeNode[] subR = new BTreeNode[2 * right.length];
        int[] lNum = new int[left.length];
        int[] rNum = new int[right.length];
        for (int i = 0; i < left.length; i++) {
            subL[i] = left[i].left;
            subL[i+1] = left[i].right;
            lNum[i] = left[i].value;
        }

        for (int i = 0; i < right.length; i++) {
            subR[i] = right[i].left;
            subR[i+1] = right[i].right;
            rNum[i] = right[i].value;
        }

//        左右数组对比
        for(int i = 0; i<left.length;i++){
            if(lNum[i] != rNum[left.length - 1 - i]){
                return false;
            }
        }

        if(isAllNull(subL) && isAllNull(subR)){
            return true;
        }

        return rua(subL, subR);
    }

    public boolean isAllNull(BTreeNode[] nodes){
        for(BTreeNode node : nodes){
            if(node != null){
                return false;
            }
        }
        return true;
    }
}
