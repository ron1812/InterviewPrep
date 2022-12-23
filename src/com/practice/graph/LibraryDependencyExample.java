package com.practice.graph;

import java.util.*;

public class LibraryDependencyExample {

    public static void main(String[] args) {
        List<List<Integer>> libraryToDependencyList = new ArrayList<>();
        libraryToDependencyList.add(Arrays.asList(3));
        libraryToDependencyList.add(Arrays.asList(0,4));
        libraryToDependencyList.add(Arrays.asList(1));

        //Cyclic check
        //libraryToDependencyList.add(Arrays.asList(0));

        System.out.println(getCompileLibrary(libraryToDependencyList));
    }

/*

    Find the order in which there wont be any compilation problem.Also find Cyclic loop and throw error

    Libraries    DEPENDENT
    0         ->   3
    1         ->   0,4
    2         ->   1


    2 -->     1  ---> 4

              |
              |
              \/

              0  --->  3

    soln : 3 , 0, 4, 1, 2

*/

    public static List<Integer> getCompileLibrary(List<List<Integer>> adjList){

        LinkedList<Integer> orderList = new LinkedList<>();

        Map<Integer,List<Integer>> mapOfLibToDepList = new HashMap<>();
        for(int i=0; i<adjList.size(); i++){
            List<Integer> dependentList = adjList.get(i);
            mapOfLibToDepList.put(i,dependentList);
        }

        //List<Integer> visitedNodes = new ArrayList<>(10);
        //Collections.fill(visitedNodes,-1);

        int[] visitedNodes = new int[10];

        for(int i=0;i<adjList.size();i++){
            List<Integer> neighboursList = adjList.get(i);
            int neighboursVisted = 0;
            HashSet<Integer> cyclicCheck = new HashSet<>();
            cyclicCheck.add(i);
            neighboursVisted = getNeighboursVisted(orderList, mapOfLibToDepList, visitedNodes, neighboursList, neighboursVisted,cyclicCheck);

            if(neighboursVisted == neighboursList.size()){
                orderList.add(i);
                //visitedNodes.add(i,1);
                visitedNodes[i] = 1;
                cyclicCheck.clear();
            }
        }

        return orderList;
    }

    private static int getNeighboursVisted(LinkedList<Integer> orderList, Map<Integer, List<Integer>> mapOfLibToDepList, int[] visitedNodes, List<Integer> neighboursList, int neighboursVisted, HashSet<Integer> cyclicCheck) {
        for(Integer neighbour : neighboursList){

            if(cyclicCheck.contains(neighbour)){
                throw new RuntimeException("This is a cyclic loop");
            }
            if(visitedNodes[neighbour] == 1){
                neighboursVisted++;
                continue;
            }
            else if(mapOfLibToDepList.containsKey(neighbour)){
                List<Integer> neighbours = mapOfLibToDepList.get(neighbour);
                getNeighboursVisted(orderList,mapOfLibToDepList,visitedNodes,neighbours,0,cyclicCheck);
            }else{
                neighboursVisted++;
                orderList.add(neighbour);
                //visitedNodes.add(neighbour,1);
                visitedNodes[neighbour] = 1;
            }
        }
        return neighboursVisted;
    }
}
