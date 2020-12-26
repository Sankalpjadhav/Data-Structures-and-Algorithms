package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of permutations of the n coins using which the
     amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of permutations and not combinations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
                  combination. You should treat them as 3 and not 1.
 */
public class CoinChangePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] coins = new int[n];
        for(int i=0;i<coins.length;i++){
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        int [] dp = new int [amount+1];
        dp[0]=1;
        for(int i=0;i<dp.length;i++){
            for(int coin:coins){
                if(coin<=i) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }
        System.out.println(dp[amount]);
    }
}
