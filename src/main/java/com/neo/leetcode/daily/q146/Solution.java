package com.neo.leetcode.daily.q146;

import java.util.HashMap;
import java.util.Optional;

public class Solution {

    public static class Node {

        private final int key;

        private final int value;


        private Node next;

        private Node prev;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    /**
     * 双端列表
     */
    public static class DoubleHeadList {

        /**
         * 头节点
         */
        private Node head;
        /**
         * 尾节点
         */
        private Node tail;

        /**
         * 元素个数
         */
        private int size;

        public DoubleHeadList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.size = 0;
            this.head.next = this.tail;
            this.tail.prev = head;
        }

        //头节点插入
        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        //尾节点删除 并返回该节点
        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        //删除链表中的某一个节点
        public void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        public int size() {
            return this.size;
        }
    }


    public static class LruCache {
        //最大容量
        private int cap;

        private DoubleHeadList cache;

        private HashMap<Integer, Node> index;

        public LruCache(int cap) {
            this.cap = cap;
            this.cache = new DoubleHeadList();
            this.index = new HashMap<>();
        }

        public int get(int key) {
            if(index.containsKey(key)){
                int value = index.get(key).value;
                //放到第一位
                put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if(index.containsKey(key)){
                //缓存中已经存在 移除旧的，将新的插入表头

                cache.remove(index.get(key));
                cache.addFirst(node);
                index.put(key, node);
            }else{
                //判断是否超过最大容量
                if(cap == index.size()){
                    Node last = cache.removeLast();
                    System.out.println("too long!!! remove" + last.toString());
                    index.remove(last.key);
                }
                index.put(key, node);
                cache.addFirst(node);
            }

        }

        public void remove(int key) {
            if(index.containsKey(key)){
                cache.remove(index.get(key));
                index.remove(key);
            }
        }


    }
}
