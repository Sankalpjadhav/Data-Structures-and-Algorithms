package com.dsaprograms.graphs;
import java.util.Scanner;
/*
1. You are given a 2d array where 0's represent land and 1's represent water.
     Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.
Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
Sample Output
3
 */
public class CountNumberOfIslands {
    static void countIslands(int [][] array, int i, int j, boolean [][] visited){
        if(i<0 || i>= array.length || j<0 || j>=array[0].length || array[i][j]==1 || visited[i][j]==true){
            return;
        }

        visited[i][j]=true;
        // Travel in all direction: north, east, south and west.
        countIslands(array, i-1, j, visited);// North
        countIslands(array, i, j+1, visited);// East
        countIslands(array, i+1, j, visited);// South
        countIslands(array, i, j-1, visited);// West
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] array = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j] = sc.nextInt();
            }
        }
       // Group of 0's represent islands and group of 1's represent water.
        int islandsCount = 0;
        boolean [][] visited = new boolean[m][n];
        for(int i=0;i< array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j]==0 && visited[i][j]==false){
                    countIslands(array, i, j, visited);
                    islandsCount++;
                }
            }
        }

        System.out.println("Number of islands: "+islandsCount);
    }
}
