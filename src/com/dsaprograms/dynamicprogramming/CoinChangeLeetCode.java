package com.dsaprograms.dynamicprogramming;
import java.util.Arrays;
import java.util.Scanner;
/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
 */
public class CoinChangeLeetCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int[n];
        for(int i=0;i<coins.length;i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        System.out.println(coinChange(coins,amount));
    }
        public static int coinChange(int[] coins, int amount) {
            int [] dp = new int[amount+1];
            Arrays.fill(dp,amount+1);
            dp[0]=0;
            for(int i=1;i<dp.length;i++){
                for(int coin=0;coin<coins.length;coin++){
                    if(i>=coins[coin]){
                        int index = i-coins[coin];
                        int value = dp[index];;
                        dp[i] = Math.min(value+1,dp[i]);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
}
