package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Largest Square Sub-matrix With All 1's
1. You are given a matrix of 0's and 1's.
2. You have to find the maximum size square sub-matrix with all 1's.
Sample Input
5 6
0 1 0 1 0 1
1 0 1 0 1 0
0 1 1 1 1 0
0 0 1 1 1 0
1 1 1 1 1 1
Sample Output
3
 */
public class LargestSquareSubmatrixOfAll1s {
    public static int getLargestSquare(int [][] array){
        int [][] dp = new int[array.length][array[0].length];
        int largestSquare = Integer.MIN_VALUE;
        for(int i = dp.length-1;i>=0;i--){
            for(int j = dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = array[i][j];
                }
                else if(i==dp.length-1){
                    dp[i][j] = array[i][j];
                }
                else if(j==dp[0].length-1){
                    dp[i][j] = array[i][j];
                }
                else{
                    if(array[i][j]==0){
                        dp[i][j] = 0;
                    }
                    else{ // 1
                        dp[i][j] = 1 + Math.min(dp[i+1][j+1] , Math.min(dp[i+1][j] , dp[i][j+1]));
                    }
                }

                if(dp[i][j] >  largestSquare){  // Very important to check for the largestSquare here because what if there were 0 everywhere except last row or last column.
                    largestSquare = dp[i][j];
                }
            }
        }
        return largestSquare;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] array = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println("Largest square sub-matrix possible: "+getLargestSquare(array));
    }
}
