package com.practice.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    /*

    Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
     */
    public static void main(String[] args) {
       char[][] test = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(test));
    }

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        int numOfIsland = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){

                if(vis[r][c] == 0 && grid[r][c] == '1'){

                    bfs(r,c,vis,grid);
                    numOfIsland++;
                }
            }
        }

        return numOfIsland;
    }

    public static void bfs(int row, int col, int[][] vis, char[][] grid){

        Queue<Pair> bfsQueue = new LinkedList<Pair>();
        bfsQueue.offer(new Pair(row,col));
        vis[row][col] = 1;

        while(!bfsQueue.isEmpty()){

            Pair<Integer,Integer> node = bfsQueue.poll();
            getNeighbours(bfsQueue,node.getKey(),node.getValue(),vis,grid);
        }
    }

    public static void getNeighbours(Queue<Pair> bfsQueue, int row, int col, int[][] vis, char[][] grid){

        int[] neighbourCheck = {-1,1};

        for(int modRow : neighbourCheck){

            int nrow = row + modRow;
            if(nrow >= 0 && nrow < grid.length && vis[nrow][col] == 0 && grid[nrow][col] == '1'){
                vis[nrow][col] = 1;
                bfsQueue.offer(new Pair(nrow,col));
            }
        }

        for(int modCol : neighbourCheck){

            int ncol = col + modCol;
            if(ncol >= 0 && ncol < grid[0].length && vis[row][ncol] == 0 && grid[row][ncol] == '1'){
                vis[row][ncol] = 1;
                bfsQueue.offer(new Pair(row,ncol));
            }
        }
    }
}
