package com.neo.leetcode.daily.q210;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    private int[] res; //返回的数组
    private int[] visited; //已经访问过的节点数组
    private Map<Integer, LinkedList<Integer>> edges; //存储有向图
    private boolean hasCycle;  //是否有环
    private int counter;

    /*
    *
    * 0未搜索 1搜索中 2已搜索
    *
    * */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        visited = new int[numCourses];
        edges = new HashMap<>();
        counter = numCourses-1;

        //先将数据存进有向图中
        for(int[] pre : prerequisites){
            LinkedList preList = edges.getOrDefault(pre[1], new LinkedList());

            preList.add(pre[0]); //后置课程
            edges.put(pre[1], preList);
        }

        for(int i = 0;i<numCourses;i++){
            //深度优先遍历
            if(visited[i] != 1 && !hasCycle){
                dfs(i);
            }

        }
        if(hasCycle){
            return new int[0];
        }
        return res;
    }

    private void dfs(int u){
        if(visited[u] == 2){
            return;
        }
        //将当前节点设置为搜索中
        System.out.println("当前节点"+ u + ",状态"+visited[u]);
        visited[u] = 1;

        //遍历其后续节点
        LinkedList<Integer> linkedList = edges.get(u);
        if(edges.containsKey(u)) {
            for (Integer next : linkedList) {
                if (visited[next] == 0) {
                    dfs(next);
                } else if (visited[next] == 1) {
                    //有环
                    hasCycle = true;
                    return;
                }
            }
        }
        visited[u] = 2;
        res[counter--] = u;
        System.out.println(u);
    }
}
