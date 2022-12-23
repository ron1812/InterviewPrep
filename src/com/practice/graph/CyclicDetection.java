package com.practice.graph;

import javafx.util.Pair;

import java.util.*;

public class CyclicDetection {

    public static void main(String[] args) {

        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList());
        adjList.add(Arrays.asList(2,3));
        adjList.add(Arrays.asList(1,5));
        adjList.add(Arrays.asList(1,4,6));
        adjList.add(Arrays.asList(3));
        adjList.add(Arrays.asList(2,7));
        adjList.add(Arrays.asList(3,7));
        adjList.add(Arrays.asList(5));

        System.out.println(isCyclicGraph(0,adjList));
    }

    /*

       -------- 2 -------- 5 --------
       |                            |
       1                            7
       |                            |
       -------- 3 -------- 6 -------
                |
                4
     */

    public static Boolean isCyclicGraph(int src,List<List<Integer>> adjList){
        Queue<Pair<Integer,Integer>> pairStack = new LinkedList<>();
        int[] visited = new int[adjList.size()+1];
        pairStack.offer(new Pair(src,-1));
        visited[src] = 1;
        while (!pairStack.isEmpty()){
            Integer node = pairStack.peek().getKey();
            Integer parent = pairStack.peek().getValue();

            pairStack.poll();

            for(Integer neighbours:adjList.get(node)){
                if(visited[neighbours] == 0){
                    visited[neighbours] = 1;
                    pairStack.offer(new Pair(neighbours,node));
                }else if(!parent.equals(neighbours)){
                    return true;
                }
            }
        }
        return false;
    }
}
