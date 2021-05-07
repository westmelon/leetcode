package com.neo.leetcode.daily.q341;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<NestedInteger> init(){
        //[1,[[[7,6],0],6,5],1,5,0,2,7]
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedInteger node1 = new NestedIntegerNode(true, 1, null);
        nestedList.add(node1);
        List<NestedInteger> list2 = new ArrayList<>();   //[[[7,6],0],6,5]
        List<NestedInteger> list21 = new ArrayList<>();  //[[7,6],0]
        List<NestedInteger> list211 = new ArrayList<>(); //[7,6]
        NestedInteger node2 = new NestedIntegerNode(false, null, list2);
        nestedList.add(node2);
        list2.add(new NestedIntegerNode(false, null, list21));
        list2.add(new NestedIntegerNode(true, 6, null));
        list2.add(new NestedIntegerNode(true, 5, null));
        list21.add(new NestedIntegerNode(false, null, list211));
        list21.add(new NestedIntegerNode(true, 0, null));
        list211.add(new NestedIntegerNode(true, 7, null));
        list211.add(new NestedIntegerNode(true, 6, null));

        nestedList.add(new NestedIntegerNode(true, 1, null));
        nestedList.add(new NestedIntegerNode(true, 5, null));
        nestedList.add(new NestedIntegerNode(true, 0, null));
        nestedList.add(new NestedIntegerNode(true, 2, null));
        nestedList.add(new NestedIntegerNode(true, 7, null));

        return nestedList;

    }
    public static void main(String[] args) {
        List<NestedInteger> nestedList = init();

        NestedIterator iterator = new NestedIterator(nestedList);

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
