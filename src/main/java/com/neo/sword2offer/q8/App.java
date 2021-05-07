package com.neo.sword2offer.q8;

import com.neo.struct.DBinaryTreeNode;

public class App {

    public static void main(String[] args) {

        DBinaryTreeNode _1 = new DBinaryTreeNode(1);
        DBinaryTreeNode _2 = new DBinaryTreeNode(2);
        DBinaryTreeNode _3 = new DBinaryTreeNode(3);
        DBinaryTreeNode _4 = new DBinaryTreeNode(4);
        DBinaryTreeNode _5 = new DBinaryTreeNode(5);
        DBinaryTreeNode _6 = new DBinaryTreeNode(6);
        DBinaryTreeNode _7 = new DBinaryTreeNode(7);
        DBinaryTreeNode _8 = new DBinaryTreeNode(8);
        DBinaryTreeNode _9 = new DBinaryTreeNode(9);

        left(_1, _2);
        right(_1, _3);
        left(_2, _4);
        right(_2, _5);
        left(_5, _8);
        right(_5, _9);
        right(_1, _3);
        left(_3, _6);
        right(_3, _7);

        Solution solution = new Solution();
        DBinaryTreeNode next = solution.findNext(_1, _9);
        System.out.println(next.value);

    }

    public static void left(DBinaryTreeNode parent, DBinaryTreeNode child) {
        parent.left = child;
        child.parent = parent;
    }

    public static void right(DBinaryTreeNode parent, DBinaryTreeNode child) {
        parent.right = child;
        child.parent = parent;
    }
}
