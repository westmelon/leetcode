package com.neo.leetcode.daily.q460;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //HashMap + 双向链表 解法与LRU相似 新增一个HashMap 存储每个频次对应的双向链表


    public static class LFUCache {


        private Map<Integer, Node> cache;

        private DoubleHeadList firstFreqList;  //最多使用的频次列表

        private DoubleHeadList lastFreqList;   //最少使用的频次列表

        private int capacity;  //缓存大小

        //初始化缓存
        public LFUCache(int capacity) {
            this.cache = new HashMap<>();

            firstFreqList = new DoubleHeadList();
            lastFreqList = new DoubleHeadList();

            firstFreqList.next = lastFreqList;
            lastFreqList.prev = firstFreqList;

            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                freqIncrease(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                Node newNode = copyOldNode(node, value);
                cache.put(key, newNode);
                freqIncrease(newNode);
            } else {
                //判断是否超过最大大小限制
                if (cache.size() == capacity) {
                    //移除使用频次最少且最早使用的
                    Node last = lastFreqList.prev.removeLast();
                    if (lastFreqList.prev.size == 0) {
                        removeDoubleList(lastFreqList.prev);
                    }
                    //缓存中移除
                    cache.remove(last.key);
                }
                //添加新的值
                Node added = new Node(key, value);
                cache.put(key, added);
                if (lastFreqList.prev.freq != 1) {
                    //新建频次为1的链表
                    DoubleHeadList newDoubleHeadList = new DoubleHeadList(1);
                    newDoubleHeadList.addFirst(added);
                    addDoubleList(newDoubleHeadList, lastFreqList.prev);
                } else {
                    lastFreqList.prev.addFirst(added);
                }

            }
        }

        private Node copyOldNode(Node old, int newValue){
            Node newNode = new Node(old.key, newValue);
            newNode.freq = old.freq;
            newNode.freqList = old.freqList;
            newNode.next = old.next;
            newNode.prev = old.prev;
            return newNode;
        }

        //节点新增访问频次
        private void freqIncrease(Node node) {
            //获取节点当前所在频次链表
            DoubleHeadList freqList = node.freqList;

            //前驱链表
            DoubleHeadList prevList = freqList.prev;

            //如果当前链表删除节点后为空，则删除该链表
            freqList.remove(node);
            if (freqList.head.next == freqList.tail) {
                removeDoubleList(freqList);
            }

            node.freq++;
            //将node加入新的链表 若对应频次的链表不存在 则新建链表
            if (prevList.freq != node.freq) {
                DoubleHeadList doubleHeadList = new DoubleHeadList(node.freq);
                doubleHeadList.addFirst(node);
                addDoubleList(doubleHeadList, prevList);
            } else {
                prevList.addFirst(node);
            }
        }

        /**
         * 给某个频次链表新增一个后驱链表
         *
         * @param doubleHeadList the head list
         * @param prevHeadList   the prev head list
         */
        private void addDoubleList(DoubleHeadList doubleHeadList, DoubleHeadList prevHeadList) {
            doubleHeadList.next = prevHeadList.next;
            doubleHeadList.prev = prevHeadList;
            prevHeadList.next.prev = doubleHeadList;
            prevHeadList.next = doubleHeadList;
        }


        /**
         * 移除某个频次链表
         *
         * @param freqList the freq list
         */
        private void removeDoubleList(DoubleHeadList freqList) {
            freqList.next.prev = freqList.prev;
            freqList.prev.next = freqList.next;
        }

    }

    //
    public static class Node {

        private final int key;

        private final int value;


        private Node next;

        private Node prev;

        //使用频次
        private int freq;

        private DoubleHeadList freqList;

        public Node() {
            this.key = 0;
            this.value = 0;
            this.freq = 0;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
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

        //头节点
        private Node head;

        //尾节点
        private Node tail;

        //双链表前驱 使用频次大
        private DoubleHeadList prev;

        //双链表后驱 使用频次小
        private DoubleHeadList next;

        //使用频次
        private int freq;
        //元素个数
        private int size;

        public DoubleHeadList() {
            this.head = new Node();
            this.tail = new Node();
            this.size = 0;
            this.head.next = this.tail;
            this.tail.prev = head;
        }

        public DoubleHeadList(int freq) {
            this.head = new Node();
            this.tail = new Node();
            this.size = 0;
            this.head.next = this.tail;
            this.tail.prev = head;
            this.freq = freq;
        }

        //头节点插入
        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            node.freqList = this;
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

}
