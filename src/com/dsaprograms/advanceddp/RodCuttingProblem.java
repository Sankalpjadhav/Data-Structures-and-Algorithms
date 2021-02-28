package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Rod Cutting Problem Dynamic Programming | Cutting Rod for Maximum Profit
1. You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to
     N.
2. You have to find the maximum value that can be obtained by selling the rod.
3. You can sell it in pieces or as a whole.
Sample Input
8
1
5
8
9
10
17
17
20
Sample Output
22
 */
public class RodCuttingProblem {
    public static int maxProfit(int[]prices){
        int [] newLengthArray = new int[prices.length+1];
        for(int i=0;i<prices.length;i++){
            newLengthArray[i+1] = prices[i];
        }
        int [] dp = new int[newLengthArray.length];
        dp[0] = 0;
        dp[1] = newLengthArray[1];
        // Cut strategy
        for(int i=2;i<dp.length;i++){
            dp[i] = newLengthArray[i];
            int left = 1;
            int right = i-1;
            while(left<=right){
                if(dp[left] + dp[right] > dp[i]){
                    dp[i] = dp[left] + dp[right];
                }
                left++;
                right--;
            }
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit after rod cutting: "+maxProfit);
    }
}
