package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */
public class LeetCode64MinimumPathSum {
    public static int getMinimumCost(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];

        for(int row = dp.length-1;row>=0; row--){
            for(int column = dp[0].length-1;column>=0;column--){
                if(row == dp.length-1 && column == dp[0].length-1){
                    dp[row][column] = grid[row][column];
                }
                else if(row == dp.length-1){
                    dp[row][column] = grid[row][column] + dp[row][column+1];
                }
                else if(column == dp[0].length-1){
                    dp[row][column] = grid[row][column] + dp[row+1][column];
                }
                else{
                    dp[row][column] = grid[row][column] + Math.min(dp[row+1][column], dp[row][column+1]);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());
        int [][] costMatrix = new int[rows][columns];
        for(int i=0;i<rows;i++){
            String line = sc.nextLine();
            for(int j=0;j<columns;j++){
                costMatrix[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }
        System.out.println("Minimum cost:"+getMinimumCost(costMatrix));
    }
}
