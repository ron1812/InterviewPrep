package com.practice.graph;

import java.util.*;
import java.util.LinkedList;

public class Graph {

    LinkedList<Integer> adjList[];

    public Graph(int size) {
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList();
        }
    }

    public void addEntry(Integer startVertex, Integer endVertex) {
        if (startVertex < adjList.length && endVertex<adjList.length) {
            adjList[startVertex].add(endVertex);
            adjList[endVertex].add(startVertex);
        }
    }

    /*
              3               5 ----  6 ----- 4
              |               |
              |               |
              0  ---- 1  ---- 2
                              |
                              |
                              7
     */
    public int shortestDistance(Integer startVertex, Integer endVertex) {
        int[] dist = new int[adjList.length];
        Arrays.fill(dist, -1);
        dist[startVertex] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            if (queue.peek() == endVertex)
                break;
            Integer removedElem = queue.poll();
            LinkedList<Integer> neighbours = adjList[removedElem];
            for (Integer neighbour : neighbours) {
                if (dist[neighbour.intValue()] != -1)
                    continue;
                dist[neighbour.intValue()] = dist[removedElem.intValue()] + 1;
                queue.add(neighbour);
            }
        }

        return dist[endVertex];
    }

    public void breadthFirst(Integer startVertex) {
        int[] visited = new int[adjList.length];
        Arrays.fill(visited, -1);
        visited[startVertex] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        System.out.print(startVertex + " ");
        while (!queue.isEmpty()) {
            Integer removedElem = queue.poll();
            LinkedList<Integer> neighbours = adjList[removedElem];
            for (Integer neighbour : neighbours) {
                if (visited[neighbour.intValue()] == 1)
                    continue;
                visited[neighbour.intValue()] = 1;
                queue.add(neighbour);
                System.out.print(neighbour + " ");
            }
        }
    }

    public void breadthFirstRecursive(Queue<Integer> q, int[] visited) {
        if (q.isEmpty())
            return;

        Integer currElem = q.poll();
        visited[currElem] = 1;
        System.out.print(currElem + " ");
        LinkedList<Integer> neighbours = adjList[currElem.intValue()];
        for (Integer neighbour : neighbours) {
            if (visited[neighbour] == 1)
                continue;
            visited[neighbour] = 1;
            //System.out.print(neighbour+" ");
            q.add(neighbour);
        }

        breadthFirstRecursive(q, visited);

    }

    public void depthFirst(Integer startVertex) {
        int[] visited = new int[adjList.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited[startVertex] = 1;
        System.out.println(" ");
        System.out.print(startVertex + " ");
        while (!stack.isEmpty()) {
            Integer currElem = stack.peek();
            LinkedList<Integer> neighbours = adjList[currElem];
            int allNeighboursVisited = 0;
            for (Integer neighbour : neighbours) {
                if (visited[neighbour.intValue()] == 1) {
                    allNeighboursVisited++;
                    if (allNeighboursVisited == neighbours.size())
                        stack.pop();
                    continue;
                }
                visited[neighbour.intValue()] = 1;
                stack.push(neighbour);
                System.out.print(neighbour + " ");
                break;
            }
        }
    }

    public void depthFirstRecursive(Integer startVertex, int visited[]) {
        visited[startVertex] = 1;
        System.out.print(startVertex + " ");
        LinkedList<Integer> neighbours = adjList[startVertex];
        for (Integer neighbour : neighbours) {
            if (visited[neighbour.intValue()] == 1) {
                continue;
            }
            depthFirstRecursive(neighbour, visited);
        }

    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < adjList.length; i++) {
            result = result + " " + i + "===>" + adjList[i].toString() + "\n";
        }
        return result;
    }


    /*


              3               5 ----  6 ----- 4
              |               |
              |               |
              0  ---- 1  ---- 2
                              |
                              |
                              7


     bfs  0 1 3 2 5 7 6 4
     dfs  0 1 2 5 6 4 7 3
     */

    public static void main(String[] args){

        Graph g = new Graph(8);
        g.addEntry(0, 1);
        g.addEntry(0, 3);
        g.addEntry(1, 2);
        g.addEntry(2, 5);
        g.addEntry(2, 7);
        g.addEntry(5, 6);
        g.addEntry(6, 4);

        System.out.println(g.toString());
        System.out.println("\nshortest distance from 0 to 5");
        System.out.println(g.shortestDistance(0, 5));
        System.out.println("\nNormal way to find out bfs");
        g.breadthFirst(0);
        System.out.println("\nRecursive way to find out bfs");
        int[] visited1 = new int[8];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        g.breadthFirstRecursive(q,visited1);

        System.out.println("\nNormal way to find out dfs");
        g.depthFirst(0);

        int[] visited = new int[8];
        System.out.println("\n Recursive way to find out dfs");
        g.depthFirstRecursive(0,visited);

    }
}
