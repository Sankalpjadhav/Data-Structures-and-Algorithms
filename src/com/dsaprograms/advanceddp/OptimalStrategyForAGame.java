package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Optimal Strategy for a Game Dynamic Programming
1. You are given an array(arr) of length N, where N is an even number.
2. The elements of the array represent N coins of values arr1,arr1...arrN.
3. You are playing a game against an opponent in an alternative way, where the opponent is equally smart.
4. In this game, a player selects either the first or the last coin from the row in every turn, removes it from the row permanently, and receives the value of the coin.
5. You have to find the maximum possible amount of money you can win if you make the first move.
Sample Input
6
20
30
2
2
2
10
Sample Output
42
 */
public class OptimalStrategyForAGame {
    public static int getMaximumAmount(int [] coins, int n){
        int [][] dp = new int[n][n];

        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap==0){
                    dp[i][j] = coins[i];
                }
                else if(gap==1){
                    dp[i][j] = Math.max(coins[i],coins[j]);
                }
                else{
                    int value1 = coins[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    int value2 = coins[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);

                    dp[i][j] = Math.max(value1, value2);
                }
            }
        }
        return dp[0][coins.length-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        System.out.println("The maximum possible amount of money you can win if you make the first move: "+getMaximumAmount(coins, n));
    }
}
