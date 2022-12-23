//package com.practice.graph;
//
//import javafx.util.Pair;
//
//import java.util.*;
//
//public class UniquePaths {
//
//    public static void main(String[] args) {
//        int row = 23;
//        int col = 12;
//
//        HashMap<Pair<Integer,Integer>, List<Pair<Integer,Integer>>> visMap = new HashMap<>();
//        visMap.put(new Pair(0,0), Arrays.asList(new Pair(0,0)));
//
//        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
//        queue.offer(new Pair(0,0));
//
//        int numberOfPaths = 0;
//
//        while(!queue.isEmpty()){
//
//            Pair<Integer, Integer> node = queue.poll();
//
//            if(node.getKey().equals(row-1) && node.getValue().equals(col-1)){
//                numberOfPaths++;
//            }
//
//            neighboursScan(node,queue,visMap,row,col);
//        }
//
//        System.out.println("Number of paths "+numberOfPaths);
//    }
//
//    private static void neighboursScan(Pair<Integer, Integer> node, Queue<Pair<Integer, Integer>> queue,
//                                       HashMap<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> ,Integer maxRow,Integer maxCol) {
//
//        Integer row = node.getKey();
//        Integer col = node.getValue();
//
//        if(col + 1 < maxCol){
//
//            Pair neighbour = new Pair(row, col + 1);
//            queue.offer(neighbour);
//            //enrichMap(visMap,neighbour,node);
//        }
//        if(row + 1 < maxRow){
//
//            Pair neighbour = new Pair(row + 1, col);
//            queue.offer(neighbour);
//            //enrichMap(visMap,neighbour,node);
//        }
//
//    }
//
//    private static void enrichMap(HashMap<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> visMap,
//                                  Pair neighbourNode, Pair<Integer, Integer> parentNode) {
//
//        if(visMap.containsKey(neighbourNode)){
//
//            List<Pair<Integer, Integer>> fromPath = visMap.get(neighbourNode);
//            fromPath.add(parentNode);
//        }else{
//
//            ArrayList<Pair<Integer, Integer>> fromPath = new ArrayList<>();
//            fromPath.add(parentNode);
//
//            visMap.put(neighbourNode,fromPath);
//        }
//    }
//}
