package com.neo.sword2offer.q8;

import com.neo.struct.BinaryTreeNode;
import com.neo.struct.DBinaryTreeNode;

public class Solution {

    /**
     * 找出中序遍历的下一个节点
     * @param root
     * @param one
     * @return
     */
    public DBinaryTreeNode findNext(DBinaryTreeNode root, DBinaryTreeNode one){
        //如果该节点有右子树, 则从子树中找下一个节点
        //如果没有右子树
        // 如果该节点是父节点的左节点 其下一个节点为其父节点
        //如果该节点是父节点的右节点 则向上搜索找到一个是左节点的父节点

        DBinaryTreeNode right = one.right;
        if(right != null){
            //有右子树的情况
            return findRightChild(right);
        } else{
            //没有右子树的情况
            return findUp(one);
        }

    }



    public DBinaryTreeNode findUp(DBinaryTreeNode node){
        DBinaryTreeNode parent = node.parent;
        if(parent == null){
            return null;
        }
        if(parent.left == node){
            return parent;
        }

        if(parent.right == node){
            return findUp(parent);
        }
        return null;
    }


    public DBinaryTreeNode findRightChild(DBinaryTreeNode right){
        if(right.left != null){
            return findRightChild(right.left);
        }
        return right;
    }
}
