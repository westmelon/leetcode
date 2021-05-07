package com.neo.simple;

public class App {
    public static void main(String[] args) {

        BTreeNode root = new BTreeNode(1);
        MirrorTree s = new MirrorTree();
        boolean mirror = s.isMirror(root);
        System.out.println(mirror);
    }
}
