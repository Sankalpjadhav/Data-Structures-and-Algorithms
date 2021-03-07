package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 221. Maximal Square
Same problem: Largest square submatrix of all 1's.
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Input: matrix = [["0"]]
Output: 0
 */
public class LeetCode221MaximalSquare {
    public static int maximalSquare(char [][] matrix){
        int maxSquare = Integer.MIN_VALUE;
        int [][] dp = new int[matrix.length][matrix[0].length];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if(i==dp.length-1){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if(j==dp[0].length-1){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else{
                    if(matrix[i][j]=='0'){
                        dp[i][j] = 0;
                    }
                    else{ // 1
                        dp[i][j] = 1 + Math.min(dp[i+1][j+1] , Math.min(dp[i+1][j] , dp[i][j+1]));
                    }
                }
                if(dp[i][j] > maxSquare){
                    maxSquare = dp[i][j];
                }
            }
        }
        return maxSquare*maxSquare;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char [][] matrix = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("The largest square containing only 1's and its area: "+maximalSquare(matrix));
    }
}
