package com.dsaprograms.recursion;
import java.util.ArrayList;
import java.util.Scanner;
/*
1219. Path with Maximum Gold
https://leetcode.com/problems/path-with-maximum-gold/
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are allowed to take one step left, right, up or down from your current position.
5. You can't visit a cell with 0 gold and the same cell more than once.
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine if
     you start and stop collecting gold from any position in the grid that has some gold.
Output Format
Maximum gold collected
Constraints
1 <= n <= 10
1 <= m <= 10
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
120
 */
public class GoldMine2 {

    static int maxGoldMine=0;
    static void findGold(int [][] grid, int row, int col, boolean [][] visited, ArrayList<Integer> bagOfGold){
        if(row<0 || col<0 || row>= grid.length || col>=grid[0].length || grid[row][col]==0 || visited[row][col]==true ){
            return;
        }
        visited[row][col]=true;
        bagOfGold.add(grid[row][col]);
        findGold(grid, row-1, col, visited, bagOfGold); // North
        findGold(grid, row, col+1, visited, bagOfGold); // East
        findGold(grid, row+1, col, visited, bagOfGold); // South
        findGold(grid, row, col-1, visited, bagOfGold); // West
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int [][] grid = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j]= sc.nextInt();
            }
        }
        boolean [][] visited = new boolean[rows][cols];
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]!=0 && visited[row][col]==false) {
                    ArrayList<Integer> bagOfGold = new ArrayList<Integer>();
                    findGold(grid, row, col, visited, bagOfGold);
                    int sum=0;
                    for(int gold:bagOfGold){
                        sum+=gold;
                    }
                    maxGoldMine = Math.max(sum, maxGoldMine);
                }
            }
        }
        System.out.println(maxGoldMine);
    }
}
